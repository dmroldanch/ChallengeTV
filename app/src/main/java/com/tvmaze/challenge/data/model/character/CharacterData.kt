package com.tvmaze.challenge.data.model.character


import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("info")
    val info: Info = Info(),
    @SerializedName("results")
    val results: List<CharacterDetailDTO> = emptyList(),
    val error: String = ""
)