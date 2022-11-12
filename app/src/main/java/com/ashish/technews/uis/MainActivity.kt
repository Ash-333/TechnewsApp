package com.ashish.technews.uis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ashish.technews.NewsApi
import com.ashish.technews.R
import com.ashish.technews.models.News
import com.ashish.technews.models.NewsArticle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter

    //var totalResult=1
    private var article = mutableListOf<NewsArticle>()

    lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewNews)
        refreshLayout = findViewById(R.id.refreshLayout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NewsAdapter(this, article)
        showNews()
    }

    fun showNews() {
        val news = NewsApi.newsInstance.getNews()
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                Log.d("Response", news.toString())
                article.addAll(news!!.articles)
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                Log.d("Error", t.message.toString())
            }
        })
    }
}