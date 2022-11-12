package com.ashish.technews.models

import com.google.gson.annotations.SerializedName

data class NewsArticle(

    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,
)
