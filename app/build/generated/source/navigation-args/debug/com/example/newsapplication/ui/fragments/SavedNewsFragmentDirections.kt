package com.example.newsapplication.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.newsapplication.R
import com.example.newsapplication.model.ArticleItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class SavedNewsFragmentDirections private constructor() {
  private data class ActionSavedNewsFragmentToArticleFragment(
    val article: ArticleItem
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_savedNewsFragment_to_articleFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(ArticleItem::class.java)) {
        result.putParcelable("article", this.article as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(ArticleItem::class.java)) {
        result.putSerializable("article", this.article as Serializable)
      } else {
        throw UnsupportedOperationException(ArticleItem::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionSavedNewsFragmentToArticleFragment(article: ArticleItem): NavDirections =
        ActionSavedNewsFragmentToArticleFragment(article)
  }
}
