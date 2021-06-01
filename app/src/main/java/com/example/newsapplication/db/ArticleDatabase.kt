package com.example.newsapplication.db

import android.content.Context
import androidx.room.*
import com.example.newsapplication.model.ArticlesItem

@Database(entities = [ArticlesItem::class],version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDao(): ArticleDao
    companion object{
        @Volatile // other threads can see when there is any change
        private var instance: ArticleDatabase?=null                                          // we have created the singleton instance of our room database
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){ // if our initail instance is null
            instance ?: createDatabase(context).also{ instance = it } // then we set the instance that we have created DB class and then create our DB
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}