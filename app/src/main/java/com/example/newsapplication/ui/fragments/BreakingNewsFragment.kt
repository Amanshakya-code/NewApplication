package com.example.newsapplication.ui.fragments

import android.app.Dialog
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AbsListView
import android.widget.Button
import android.widget.ImageView
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
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet.*
import kotlinx.android.synthetic.main.fragment_breaking_news.*


class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG = "BreakingNewsFragment"
    override fun onStart() {
        super.onStart()
        (activity as MainActivity).bottomnavigationgraph.visibility = View.VISIBLE
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).window.statusBarColor = resources.getColor(R.color.darkYellow, (activity as MainActivity).theme)
        viewModel = (activity as MainActivity).viewModel
        setupRecycleView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_breakingNewsFragment_to_articleFragment,bundle)
        }
        bottomdialogsheet.setOnClickListener {
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
            val crossbutton = dialog.findViewById<ImageView>(R.id.crossButton)
            val america = dialog.findViewById<Chip>(R.id.america)
            val india = dialog.findViewById<Chip>(R.id.India)
            val russia = dialog.findViewById<Chip>(R.id.russia)
            val france = dialog.findViewById<Chip>(R.id.france)
            val brazil = dialog.findViewById<Chip>(R.id.Brazil)
            val japan = dialog.findViewById<Chip>(R.id.japan)
            val germany = dialog.findViewById<Chip>(R.id.germany)
            val canada = dialog.findViewById<Chip>(R.id.canada)
            val southkorea = dialog.findViewById<Chip>(R.id.southkorea)
            val apply = dialog.findViewById<Button>(R.id.apply)
            try {
                america.isChecked = (activity as MainActivity).updatechip("america")
                india.isChecked = (activity as MainActivity).updatechip("india")
                russia.isChecked = (activity as MainActivity).updatechip("russia")
                france.isChecked = (activity as MainActivity).updatechip("france")
                brazil.isChecked = (activity as MainActivity).updatechip("brazil")
                japan.isChecked = (activity as MainActivity).updatechip("brazil")
                germany.isChecked = (activity as MainActivity).updatechip("germany")
                canada.isChecked = (activity as MainActivity).updatechip("canada")
                southkorea.isChecked = (activity as MainActivity).updatechip("southkorea")
            }catch (e:Exception){

            }
            dialog.show()
            apply.setOnClickListener {
                (activity as MainActivity).cleardata()
                showmainprogressbar()
                if(america.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("us")
                    (activity as MainActivity).SaveIntoSharePref("america",america.isChecked,"us","ameri")
                    Toast.makeText(requireContext(),"America News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(india.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("in")
                    (activity as MainActivity).SaveIntoSharePref("india",india.isChecked,"in","ind")
                    Toast.makeText(requireContext(),"India News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(russia.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("ru")
                    (activity as MainActivity).SaveIntoSharePref("russia",russia.isChecked,"ru","rus")
                    Toast.makeText(requireContext(),"Russia News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(france.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("fr")
                    (activity as MainActivity).SaveIntoSharePref("france",france.isChecked,"fr","fran")
                    Toast.makeText(requireContext(),"France News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(brazil.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("br")
                    (activity as MainActivity).SaveIntoSharePref("brazil",brazil.isChecked,"br","braz")
                    Toast.makeText(requireContext(),"Brazil News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(japan.isChecked){
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("jp")
                    (activity as MainActivity).SaveIntoSharePref("japan",japan.isChecked,"jp","jap")
                    Toast.makeText(requireContext(),"Japan News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(germany.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("de")
                    (activity as MainActivity).SaveIntoSharePref("germany",germany.isChecked,"de","ger")
                    Toast.makeText(requireContext(),"Germany News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(canada.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("ca")
                    (activity as MainActivity).SaveIntoSharePref("canada",canada.isChecked,"ca","can")
                    Toast.makeText(requireContext(),"Canada News Feed",Toast.LENGTH_SHORT).show()
                }
                else if(southkorea.isChecked)
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("kr")
                    (activity as MainActivity).SaveIntoSharePref("southkorea",southkorea.isChecked,"kr","korea")
                    Toast.makeText(requireContext(),"South Korea News Feed",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    viewModel.breakingNewsResponse = null
                    viewModel.breakingNewsPage = 1
                    viewModel.getBreakingNews("in")
                    (activity as MainActivity).SaveIntoSharePref("india News Feed",india.isChecked,"in","ind")
                }
                dialog.dismiss()
            }

            crossbutton.setOnClickListener {
                dialog.dismiss()
            }
            card1.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"business")
                categorytext.text = "BUSINESS"
                dialog.dismiss()
            }
            card2.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"entertainment")
                categorytext.text = "ENTERTAINMENT"
                dialog.dismiss()
            }
            card3.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"general")
                categorytext.text = "GENERAL"
                dialog.dismiss()
            }
            card4.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"health")
                categorytext.text = "HEALTH"
                dialog.dismiss()
            }
            card5.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"science")
                categorytext.text = "SCIENCE"
                dialog.dismiss()
            }
            card6.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"sports")
                categorytext.text = "SPORTS"
                dialog.dismiss()
            }
            card7.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null
                viewModel.breakingNewsPage = 1
                viewModel.getCategoryNews(COUNTRY_CODE,"technology")
                categorytext.text = "TECHNOLOGY"
                dialog.dismiss()
            }
            card8.setOnClickListener {
                showmainprogressbar()
                viewModel.breakingNewsResponse = null;
                viewModel.breakingNewsPage = 1
                viewModel.getBreakingNews(countryCode = COUNTRY_CODE)
                categorytext.text = ""
                dialog.dismiss()
            }


            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.dialogopanimation
            dialog.window?.setGravity(Gravity.BOTTOM)

        }

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response->
            when(response){
                is Resource.Success ->{
                    hidemainprogressbar()
                    hideShimmer()
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
                    hideShimmer()
                    hidemainprogressbar()
                    response.message?.let {
                        Toast.makeText(activity,"You have requested too many results. Developer accounts are limited to a max of 100 results",Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading ->{
                    showShimmer()
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
                showmainprogressbar()
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

    private fun hidemainprogressbar(){
        progressBar.visibility = View.GONE
        loadingBack.visibility = View.GONE
    }
    private fun showmainprogressbar(){
        progressBar.visibility = View.VISIBLE
        loadingBack.visibility = View.VISIBLE
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