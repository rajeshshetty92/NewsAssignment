package com.rajesh.newsassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajesh.newsassignment.model.repository.ArticleRepository
import kotlinx.coroutines.launch
import com.rajesh.newsassignment.utils.LoadingState

class ArticleViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    val data = articleRepository.data


     fun fetchData(country: String,api_key:String) {
        viewModelScope.launch {

            runCatching {
                _loadingState.value = LoadingState.LOADING
                articleRepository.refresh(country,api_key)
                _loadingState.value = LoadingState.LOADED
            }.onFailure {
                _loadingState.value = LoadingState.error(it.message)
            }
        }
    }
}