package com.tvmaze.challenge.data.model.show.detail


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("previousepisode")
    val previousepisode: Previousepisode,
    @SerializedName("self")
    val self: Self
)