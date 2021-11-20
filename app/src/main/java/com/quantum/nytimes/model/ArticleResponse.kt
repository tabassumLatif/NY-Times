package com.quantum.nytimes.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    val status: String,
    val copyright: String,
    @SerializedName("num_Results")
    val numResults: Int,
    @SerializedName("results")
    val articles: List<Article>

)
