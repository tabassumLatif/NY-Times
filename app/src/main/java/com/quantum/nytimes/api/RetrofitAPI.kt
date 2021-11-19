package com.quantum.nytimes.api

import com.quantum.nytimes.BuildConfig.API_KEY
import com.quantum.nytimes.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("mostviewed/all-sections/{page}")
    suspend fun getArticles(
            @Path("page") page : String,
            @Query("api-key") apiKey : String = API_KEY
    ) : Response<ArticleResponse>
}