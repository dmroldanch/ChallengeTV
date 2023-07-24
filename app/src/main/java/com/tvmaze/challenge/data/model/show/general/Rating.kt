package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Any
)