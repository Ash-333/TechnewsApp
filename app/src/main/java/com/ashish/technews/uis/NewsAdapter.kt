package com.ashish.technews.uis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ashish.technews.R
import com.ashish.technews.models.NewsArticle
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context, val newsArticles: MutableList<NewsArticle>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.news_items, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = newsArticles[position]
        holder.title.text = article.title
        holder.description.text = article.description
        Glide.with(holder.itemView.context).load(article.urlToImage).into(holder.image)
    }

    override fun getItemCount() = newsArticles.size

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.titleText)!!
        val description = view.findViewById<TextView>(R.id.descriptionText)!!
        val image = view.findViewById<ImageView>(R.id.NewsImage)!!
    }

}