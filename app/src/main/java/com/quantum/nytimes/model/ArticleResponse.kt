package com.quantum.nytimes.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    val status: String,
    val copyright: String,
    @SerializedName("numResults")
    val num_results: Int,
    val articles: List<Article>

)
