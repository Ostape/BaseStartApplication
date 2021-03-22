package com.robosh.basestartapplication.net.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<PokemonReference>
) {
    data class PokemonReference(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}