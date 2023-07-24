package com.tvmaze.challenge.data.model.show.talent


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("country")
    val country: Country,
    @SerializedName("deathday")
    val deathday: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated")
    val updated: Int,
    @SerializedName("url")
    val url: String
)