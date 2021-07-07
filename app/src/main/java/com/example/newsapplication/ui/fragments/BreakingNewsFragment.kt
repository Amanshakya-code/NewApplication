package com.example.newsapplication.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.adapters.NewsAdapter
import com.example.newsapplication.ui.MainActivity
import com.example.newsapplication.ui.NewsViewModel
import com.example.newsapplication.util.Constants.Companion.COUNTRY_CODE
import com.example.newsapplication.util.Constants.Companion.QUERY_PAGE_SIZE
import com.example.newsapplication.util.Resource
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG = "BreakingNewsFragment"
    override fun onStart() {
        super.onStart()
        (activity as MainActivity).header.visibility = View.VISIBLE
        (activity as MainActivity).bottomNavigationView.visibility = View.VISIBLE
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecycleView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_breakingNewsFragment_to_articleFragment,bundle)
        }
        (activity as MainActivity).bottomDrawer.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.bottomsheet)
            val card1 = dialog.findViewById<MaterialCardView>(R.id.card1)
            val card2 = dialog.findViewById<MaterialCardView>(R.id.card2)
            val card3 = dialog.findViewById<MaterialCardView>(R.id.card3)
            val card4 = dialog.findViewById<MaterialCardView>(R.id.card4)
            val card5 = dialog.findViewById<MaterialCardView>(R.id.card5)
            val card6 = dialog.findViewById<MaterialCardView>(R.id.card6)
            val card7 = dialog.findViewById<MaterialCardView>(R.id.card7)
            val card8 = dialog.findViewById<MaterialCardView>(R.id.card8)
            card1.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"business")
                dialog.dismiss()
            }
            card2.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"entertainment")
                dialog.dismiss()
            }
            card3.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"general")
                dialog.dismiss()
            }
            card4.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"health")
                dialog.dismiss()
            }
            card5.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"science")
                dialog.dismiss()
            }
            card6.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"sports")
                dialog.dismiss()
            }
            card7.setOnClickListener {
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"technology")
                dialog.dismiss()
            }
            card8.setOnClickListener {
                viewModel.breakingNewsResponse = null;
                viewModel.breakingNewsPage = 1
                viewModel.getBreakingNews(countryCode = COUNTRY_CODE)
                dialog.dismiss()
            }

            dialog.show()
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.dialogopanimation
            dialog.window?.setGravity(Gravity.BOTTOM)

        }

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response->
            when(response){
                is Resource.Success ->{
                    hideShimmer()
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        Log.d("aman","livedata --> ${newsResponse.articles}")
                        newsAdapter.differ.submitList(newsResponse.articles?.toList())//error for pagination
                        val totalPages = ((newsResponse.totalResults)?.div((QUERY_PAGE_SIZE)))?.plus(
                            2
                        )
                        isLastPage = viewModel.breakingNewsPage == totalPages
                        if(isLastPage){
                            rvBreakingNews.setPadding(0,0,0,0)
                        }
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity,"You have requested too many results. Developer accounts are limited to a max of 100 results",Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading ->{
                    showShimmer()
                    showProgressBar()
                }
            }
        })

    }
    var isLoading = false
    var isLastPage = false
    var isScrolling = false
    var scrollListener = object: RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstvisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstvisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeginning = firstvisibleItemPosition >=0
            val isTotalMoreThanVisible = totalItemCount>= QUERY_PAGE_SIZE
            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning && isTotalMoreThanVisible && isScrolling
            if(shouldPaginate){
                viewModel.getBreakingNews(COUNTRY_CODE)
                isScrolling = false
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }
        }
    }

    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
        isLoading = false
    }
    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
        isLoading = true
    }
    private fun setupRecycleView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@BreakingNewsFragment.scrollListener)
        }
    }
    private fun hideShimmer() {
        shimmer.stopShimmer()
        shimmer.visibility = View.GONE
    }

    private fun showShimmer() {
        shimmer.startShimmer()
    }


}