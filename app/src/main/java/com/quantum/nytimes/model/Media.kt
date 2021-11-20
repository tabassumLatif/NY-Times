package com.quantum.nytimes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Media (
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    val approved_for_syndication: Int,
    @SerializedName("media-metadata")
    val mediaMetaData: ArrayList<MediaMetaData>
): Serializable