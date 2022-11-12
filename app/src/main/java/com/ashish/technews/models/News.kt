package com.ashish.technews.models

import com.google.gson.annotations.SerializedName

data class News(

    @field:SerializedName("totalResults")
    val totalResults: Int,

    @field:SerializedName("articles")
    val articles: List<NewsArticle>,

    @field:SerializedName("status")
    val status: String
)
