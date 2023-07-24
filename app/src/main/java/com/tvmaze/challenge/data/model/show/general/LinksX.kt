package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("nextepisode")
    val nextepisode: Nextepisode,
    @SerializedName("previousepisode")
    val previousepisode: Previousepisode,
)