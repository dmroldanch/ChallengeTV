package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class WebChannel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("officialSite")
    val officialSite: String
)