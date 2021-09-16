package com.example.newsapplication.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.newsapplication.model.ArticleItem
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class ArticleFragmentArgs(
  val article: ArticleItem
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): ArticleFragmentArgs {
      bundle.setClassLoader(ArticleFragmentArgs::class.java.classLoader)
      val __article : ArticleItem?
      if (bundle.containsKey("article")) {
        if (Parcelable::class.java.isAssignableFrom(ArticleItem::class.java) ||
            Serializable::class.java.isAssignableFrom(ArticleItem::class.java)) {
          __article = bundle.get("article") as ArticleItem?
        } else {
          throw UnsupportedOperationException(ArticleItem::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__article == null) {
          throw IllegalArgumentException("Argument \"article\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"article\" is missing and does not have an android:defaultValue")
      }
      return ArticleFragmentArgs(__article)
    }
  }
}
