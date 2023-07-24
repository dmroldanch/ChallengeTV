package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class Externals(
    @SerializedName("imdb")
    val imdb: String,
    @SerializedName("thetvdb")
    val thetvdb: Int,
    @SerializedName("tvrage")
    val tvrage: Int
)