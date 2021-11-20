package com.quantum.nytimes.ui.articles.adapter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.quantum.nytimes.model.Article

class ArticleItemViewModel(article: Article) {
    val title = MutableLiveData(article.title)
    val abstract = MutableLiveData(article.abstract)
    val thumb = MutableLiveData("")

    init {
        if (article.media.isNotEmpty() && article.media[0].mediaMetaData.isNotEmpty())
            thumb.value = article.media[0].mediaMetaData[0].url
        Log.d("tabi", "  ${thumb.value} ")
    }
}