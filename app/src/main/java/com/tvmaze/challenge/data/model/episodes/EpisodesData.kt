package com.tvmaze.challenge.data.model.episodes


import com.google.gson.annotations.SerializedName

data class EpisodesData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<EpisodeDetailDTO>
)