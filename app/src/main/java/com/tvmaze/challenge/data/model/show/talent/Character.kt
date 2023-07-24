package com.tvmaze.challenge.data.model.show.talent


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)