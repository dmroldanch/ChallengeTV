package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String
)