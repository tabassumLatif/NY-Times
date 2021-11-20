package com.quantum.nytimes.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quantum.nytimes.model.Article
import com.quantum.nytimes.model.ArticleResponse
import com.quantum.nytimes.repository.NyTimeRepositoryInterface
import com.quantum.nytimes.utils.Resource
import kotlinx.coroutines.launch

class ArticlesViewModel @ViewModelInject constructor(
    private val repository: NyTimeRepositoryInterface
) : ViewModel() {

    private val articlesResponse = MutableLiveData<Resource<ArticleResponse>>()
    val articles = MutableLiveData<List<Article>>()
    val showLoader = MutableLiveData(false)
    private var lastPageId = 1

    fun fetchArticle() {
        if(showLoader.value != true) {
            showLoader.value = true
            articlesResponse.value = Resource.loading(null)
            viewModelScope.launch {
                val response = repository.getArticles(lastPageId)
                showLoader.postValue(false)
                if (response.data != null) {
                    articles.postValue(response.data?.articles)
                    lastPageId++
                }
            }
        }
    }

}