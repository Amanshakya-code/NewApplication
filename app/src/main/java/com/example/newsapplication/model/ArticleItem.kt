package com.example.newsapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "articles")
data class ArticleItem(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val publishedAt: String?,
    val author: String?,
    val urlToImage: String?,
    val description: String?,
    val source: Source?,
    val title: String?,
    val url: String,
    val content: String?,
    var isExpanded:Boolean = false
): Serializable