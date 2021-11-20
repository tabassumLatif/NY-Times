package com.quantum.nytimes.repository

import com.quantum.nytimes.api.RetrofitAPI
import com.quantum.nytimes.model.ArticleResponse
import com.quantum.nytimes.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class NyTimeRepository @Inject constructor(private val retrofitAPI: RetrofitAPI): NyTimeRepositoryInterface {
    override suspend fun getArticles(pageId: Int): Resource<ArticleResponse> {
        return try {
            val response = retrofitAPI.getArticles("$pageId.json")
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }
}