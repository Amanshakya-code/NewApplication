package com.example.newsapplication.model

import com.example.newsapplication.model.ArticlesItem

data class NewsResponse(
    val totalResults: Int? = null,
    val articles: MutableList<ArticlesItem?>? = null,
    val status: String? = null
)




