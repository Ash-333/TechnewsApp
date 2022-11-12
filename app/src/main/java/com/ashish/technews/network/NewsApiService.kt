package com.ashish.technews

import com.ashish.technews.models.News
import com.ashish.technews.models.NewsArticle
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://saurav.tech/NewsAPI/top-headlines/category/technology/"

interface NewsApiService {

    @GET("in.json")

    fun getNews(): Call<News>
}

object NewsApi {
    val newsInstance: NewsApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsApiService::class.java)
    }
}