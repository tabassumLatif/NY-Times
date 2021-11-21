package com.quantum.nytimes.ui.articles.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quantum.nytimes.model.Article

class ArticleDetailViewModel @ViewModelInject constructor() : ViewModel() {
    val title = MutableLiveData("")
    val abstract = MutableLiveData("")
    val banner = MutableLiveData("")
    val source = MutableLiveData("")
    val publishDate = MutableLiveData("")

    fun setArticle(article: Article) {
        title.value = article.title
        abstract.value = article.abstract
        if (article.media.isNotEmpty() && article.media[0].mediaMetaData.size >= 2) {
            banner.value = article.media[0].mediaMetaData[2].url
        }
        source.value = "By the ${article.source}"
        publishDate.value =
            "Publish on " + article.published_date + "\t  Updated on " + article.updated
    }
}