package com.example.newsapplication.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.adapters.NewsAdapter
import com.example.newsapplication.ui.MainActivity
import com.example.newsapplication.ui.NewsViewModel
import com.example.newsapplication.util.Constants
import com.example.newsapplication.util.Resource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import kotlinx.android.synthetic.main.fragment_breaking_news.paginationProgressBar
import kotlinx.android.synthetic.main.fragment_search_news.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchNewsFragment: Fragment(R.layout.fragment_search_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val  TAG = "searchNewsFragment"
    override fun onStart() {
        super.onStart()
        (activity as MainActivity).bottomnavigationgraph.visibility = View.VISIBLE
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecycleView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_searchNewsFragment_to_articleFragment,bundle)

        }


        var job: Job? = null
        etSearch.addTextChangedListener { editable->
            job?.cancel()
            job = MainScope().launch {
                delay(500L)
                editable?.let {
                    if(editable.toString().isNotEmpty())
                    {
                        clearText.visibility = View.VISIBLE
                        searchIllustration.visibility = View.GONE
                        showshim()
                        viewModel.searchNewsResponse = null
                        viewModel.searchNewsPage = 1
                        viewModel.searchNews(editable.toString())
                    }
                    else{
                        clearText.visibility = View.GONE
                    }
                }
            }
        }
        clearText.setOnClickListener {
            etSearch.text!!.clear()
        }

        viewModel.searchNews.observe(viewLifecycleOwner, Observer { response->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    hideshim()
                    response.data?.let { newsResponse ->
                        if(newsResponse.articles?.toList()!!.isEmpty()){
                            searchIllustration.visibility = View.GONE
                        }
                        newsAdapter.differ.submitList(newsResponse.articles?.toList())
                        val totalPages = ((newsResponse.totalResults)?.div((Constants.QUERY_PAGE_SIZE)))?.plus(
                            2
                        )
                        isLastPage = viewModel.searchNewsPage == totalPages
                        if(isLastPage){
                            rvSearchNews.setPadding(0,0,0,0)
                        }
                    }
                }
                is Resource.Error ->{
                    hideshim()
                    hideProgressBar()
                    searchIllustration.visibility = View.VISIBLE
                    response.message?.let {
                        Toast.makeText(activity,"You have requested too many results. Developer accounts are limited to a max of 100 results.", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading ->{
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
            val isTotalMoreThanVisible = totalItemCount>= Constants.QUERY_PAGE_SIZE
            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning && isTotalMoreThanVisible && isScrolling
            if(shouldPaginate){
                viewModel.searchNews(etSearch.text.toString())
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
        rvSearchNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@SearchNewsFragment.scrollListener)
        }
    }
    private fun hideshim() {
        shim.stopShimmer()
        shim.visibility = View.GONE
    }

    private fun showshim() {
        shim.visibility = View.VISIBLE
        shim.startShimmer()
    }
}