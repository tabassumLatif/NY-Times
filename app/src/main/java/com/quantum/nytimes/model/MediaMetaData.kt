package com.quantum.nytimes.model

import java.io.Serializable

data class MediaMetaData(
    val url: String,
    val format: String,
    val height: Int,
    val width: Int
): Serializable