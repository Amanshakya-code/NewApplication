package com.example.newsapplication.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ParseException
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.newsapplication.model.ArticlesItem
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_article_preview.view.*
import kotlinx.android.synthetic.main.item_article_preview.view.ivArticleImage
import kotlinx.android.synthetic.main.item_article_preview.view.tvDescription
import kotlinx.android.synthetic.main.item_article_preview.view.tvPublishedAt
import kotlinx.android.synthetic.main.item_article_preview.view.tvSource
import kotlinx.android.synthetic.main.item_article_preview.view.tvTitle
import kotlinx.android.synthetic.main.item_preview_saved.view.*
import java.text.SimpleDateFormat
import java.util.*

class SavedAdapter:RecyclerView.Adapter<SavedAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<ArticlesItem>() {
        override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem.url == newItem.url // why we haven use id to compare bcz in getting data from api we dont have any id associated to it but there is always unique url
        }

        override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_preview_saved, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text = article.source?.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = formattedDate((article.publishedAt).toString())
            author.text = "by:-"+article.author.toString()
            content.text = article.content
            setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
            setOnLongClickListener {
                val shareIntent = Intent().apply {
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_TEXT,article.title+"\n"+"by:- "+article.source?.name+"\n"+"#NewsApp"+"\n"+article.url)
                    this.type = "text/plain"
                }
                context.startActivity(shareIntent)
                true
            }
        }
    }
    private var onItemClickListener: ((ArticlesItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (ArticlesItem) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private fun formattedDate(utcTime: String): String? {
        var date: Date? = null
        @SuppressLint("SimpleDateFormat") val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        try {
            date = format.parse(utcTime.replace("Z$".toRegex(), "+0000"))
        } catch (e: ParseException) {
            e.printStackTrace()
        } catch (e: java.text.ParseException) {
            e.printStackTrace()
        }
        assert(date != null)
        @SuppressLint("SimpleDateFormat") val dateFormat = SimpleDateFormat("LLL dd, yyyy")
        @SuppressLint("SimpleDateFormat") val timeFormat = SimpleDateFormat("h:mm a")
        return """
            ${dateFormat.format(date)}
            ${timeFormat.format(date)}
            """.trimIndent()
    }
}

