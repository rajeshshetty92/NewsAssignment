package com.rajesh.newsassignment.model.api

import com.rajesh.newsassignment.model.ArticlesList
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

    @GET("top-headlines")
    fun getTopArticleAsync(@Query("country") country: String, @Query("apiKey") api_key: String): Deferred<ArticlesList>
}