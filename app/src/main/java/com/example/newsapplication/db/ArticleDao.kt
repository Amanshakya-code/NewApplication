package com.example.newsapplication.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.newsapplication.model.ArticlesItem

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticlesItem):Long

    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<ArticlesItem>>

    @Delete
    suspend fun deleteArticle(article: ArticlesItem)

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticle()

}