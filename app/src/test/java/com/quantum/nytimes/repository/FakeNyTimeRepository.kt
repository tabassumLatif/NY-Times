package com.quantum.nytimes.repository

import com.quantum.nytimes.model.ArticleResponse
import com.quantum.nytimes.utils.Resource

class FakeNyTimeRepository : NyTimeRepositoryInterface {
    override suspend fun getArticles(pageId: Int): Resource<ArticleResponse> {
        TODO("Not yet implemented")
    }

}