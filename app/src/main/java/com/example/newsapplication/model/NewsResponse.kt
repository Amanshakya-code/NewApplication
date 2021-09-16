package com.example.newsapplication.model

data class NewsResponse(
    val totalResults: Int? = null,
    val articles: MutableList<ArticleItem?>? = null,
    val status: String? = null
)




