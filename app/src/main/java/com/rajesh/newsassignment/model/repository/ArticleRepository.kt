package com.rajesh.newsassignment.model.repository

import androidx.lifecycle.MutableLiveData
import com.rajesh.newsassignment.model.ArticleTable
import com.rajesh.newsassignment.model.api.ArticleApi
import com.rajesh.newsassignment.model.dao.ArticleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.rajesh.newsassignment.model.entity.Article

class ArticleRepository(private val articleApi: ArticleApi, private val articleDao: ArticleDao) {

    val data = MutableLiveData<List<Article>>()
    private var savedData = MutableLiveData<List<ArticleTable>>()

    suspend fun refresh(country: String, api_key: String) {
        withContext(Dispatchers.IO) {
            val articles = articleApi.getTopArticleAsync(country,api_key).await()
            data.postValue(articles.articles)
        }
    }

    fun getSavedArticle() {
        savedData = articleDao.findAll() as MutableLiveData<List<ArticleTable>>
    }
}