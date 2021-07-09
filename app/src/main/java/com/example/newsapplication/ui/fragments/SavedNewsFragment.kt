package com.example.newsapplication.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.adapters.NewsAdapter
import com.example.newsapplication.adapters.SavedAdapter
import com.example.newsapplication.model.ArticlesItem
import com.example.newsapplication.ui.MainActivity
import com.example.newsapplication.ui.NewsViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import kotlinx.android.synthetic.main.fragment_saved_news.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    //dnnewin

    lateinit var viewModel: NewsViewModel
    lateinit var savedAdapter: SavedAdapter
    lateinit var savedarticleList:ArrayList<ArticlesItem>
    lateinit var tempsavedList:ArrayList<ArticlesItem>
    var job: Job? = null
    override fun onStart() {
        super.onStart()
        (activity as MainActivity).bottomnavigationgraph.visibility = View.VISIBLE
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).window.statusBarColor = resources.getColor(R.color.light_blue, (activity as MainActivity).theme)
        savedarticleList = ArrayList()
        tempsavedList = ArrayList()


        viewModel = (activity as MainActivity).viewModel
        setupRecycleView()
//        savedAdapter.setOnItemClickListener {
//            val bundle = Bundle().apply {
//                putSerializable("article",it)
//            }
//            findNavController().navigate(R.id.action_savedNewsFragment_to_articleFragment,bundle)
//        }

        val itemTochHelperCallBack = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = savedAdapter.differ.currentList[position]
                viewModel.deleteArticle(article)
                Snackbar.make(view,"Successfully deleted Article",Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        viewModel.saveArticle(article)
                    }
                    show()
                }
            }
        }
        ItemTouchHelper(itemTochHelperCallBack).apply {
            attachToRecyclerView(rvSavedNews)
        }
        deleteAllArticlebtn.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext(), R.style.CustomMaterialDialog)
                .setIcon(R.drawable.ic_baseline_delete_outline_24)
                .setTitle("Delete All Articles")
                .setMessage("Are you sure You want to delete All saved news? You can Also Delete with Left & Right Swipes")
                .setPositiveButton("Yes") { _, _ ->
                    viewModel.deleteAllArticle()
                }
                .setNegativeButton("No") { _, _ ->
                }
                .show()
        }

        viewModel.getsavedNews().observe(viewLifecycleOwner, Observer{ articles->
            savedarticleList = ArrayList(articles)
            if(articles.size == 0)
            {
                nothavingsavedarticle.visibility = View.VISIBLE
                nonewsaved.visibility = View.VISIBLE
                exploreNews.visibility = View.VISIBLE
            }
            else
            {
                nothavingsavedarticle.visibility = View.GONE
                nonewsaved.visibility = View.GONE
                exploreNews.visibility = View.GONE
            }
            savedAdapter.differ.submitList(articles)
        })
        setupsearchba()
        cleartextsaved.setOnClickListener {
            savedSearch.text!!.clear()
            cleartextsaved.visibility = View.GONE
        }
        exploreNews.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupsearchba() {
        savedSearch.addTextChangedListener { text: Editable? ->
            var textsearch = text.toString().trim()
            if (textsearch.isNotEmpty() && savedarticleList.isNotEmpty()) {
                loadblacksaved.visibility = View.VISIBLE
                savedprogressbar.visibility = View.VISIBLE
                job?.cancel()
                job = MainScope().launch {
                    delay(500L)
                    cleartextsaved.visibility = View.VISIBLE
                    text?.let {
                        displaysearch(textsearch)
                    }
                }
            }else
            {
                viewModel.getsavedNews().observe(viewLifecycleOwner, Observer{ articles->
                    savedarticleList = ArrayList(articles)
                    if(articles.size == 0)
                    {
                        nothavingsavedarticle.visibility = View.VISIBLE
                        nonewsaved.visibility = View.VISIBLE
                        exploreNews.visibility = View.VISIBLE
                    }
                    else
                    {
                        nothavingsavedarticle.visibility = View.GONE
                        nonewsaved.visibility = View.GONE
                        exploreNews.visibility = View.GONE
                    }
                    savedAdapter.differ.submitList(articles)
                })
            }
        }
    }

    private fun displaysearch(textsearch: String) {
        if(savedarticleList.isNotEmpty()){
            tempsavedList.clear()
            tempsavedList.addAll(
                savedarticleList.filter { article ->
                    article.title!!.contains(textsearch,true)
                }
            )
            loadblacksaved.visibility = View.GONE
            savedprogressbar.visibility = View.GONE
            savedAdapter.differ.submitList(tempsavedList)
            savedAdapter.notifyDataSetChanged()
        }
        if(tempsavedList.isEmpty())
        {
            nothavingsavedarticle.visibility = View.VISIBLE
            nonewsaved.visibility = View.VISIBLE
            exploreNews.visibility = View.VISIBLE
        }
        else{
            nothavingsavedarticle.visibility = View.GONE
            nonewsaved.visibility = View.GONE
            exploreNews.visibility = View.GONE
        }

    }

    private fun setupRecycleView(){
        savedAdapter = SavedAdapter()
        rvSavedNews.apply {
            adapter = savedAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}