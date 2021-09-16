package com.example.newsapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapplication.model.ArticleItem

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticleItem):Long

    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<ArticleItem>>

    @Delete
    suspend fun deleteArticle(article: ArticleItem)

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticle()

}