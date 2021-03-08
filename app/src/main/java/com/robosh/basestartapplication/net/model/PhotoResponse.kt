package com.robosh.basestartapplication.net.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("urls")
    val urls: Url
) {
    data class Url(
        @SerializedName("raw")
        val raw: String?,
        @SerializedName("full")
        val full: String?,
        @SerializedName("small")
        val small: String?
    )
}