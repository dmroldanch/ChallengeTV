package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: Self,
    @SerializedName("show")
    val show: Show
)