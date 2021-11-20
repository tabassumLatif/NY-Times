package com.quantum.nytimes.repository

import com.quantum.nytimes.model.ArticleResponse
import com.quantum.nytimes.utils.Resource

interface NyTimeRepositoryInterface {
    suspend fun getArticles(pageId: Int = 0):Resource<ArticleResponse>
}