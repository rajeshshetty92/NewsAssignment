package com.rajesh.newsassignment.model


import com.google.gson.annotations.SerializedName
import com.rajesh.newsassignment.model.entity.Article

data class ArticlesList(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)