package com.quantum.nytimes.model

import com.google.gson.annotations.SerializedName

data class Article(
    val uri: String,
    val url: String,
    val id: String,
    @SerializedName("asset_id")
    val assetId: String,
    val source: String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    @SerializedName("adx_keywords")
    val adxKeywords: String,
    val column: String?,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
)