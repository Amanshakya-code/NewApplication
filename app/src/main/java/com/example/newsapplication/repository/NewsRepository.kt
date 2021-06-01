package com.example.newsapplication.repository

import com.example.newsapplication.api.RetrofitInstance
import com.example.newsapplication.db.ArticleDatabase
import com.example.newsapplication.model.ArticlesItem

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery:String,pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: ArticlesItem) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: ArticlesItem) = db.getArticleDao().deleteArticle(article)
}