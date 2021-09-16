package com.example.newsapplication.repository

import com.example.newsapplication.api.RetrofitInstance
import com.example.newsapplication.db.ArticleDatabase
import com.example.newsapplication.model.ArticleItem

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery:String,pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: ArticleItem) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: ArticleItem) = db.getArticleDao().deleteArticle(article)

    suspend fun getCategoryNews(countryCode: String,category:String,pageNumber:Int) =
        RetrofitInstance.api.getCategoryNews(countryCode,category,pageNumber)

    suspend fun DeleteAllArticle() = db.getArticleDao().deleteAllArticle()
}