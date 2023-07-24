package com.tvmaze.challenge.data.model.show.talent


import com.google.gson.annotations.SerializedName

data class TalentDTO(
    @SerializedName("character")
    val character: Character,
    @SerializedName("person")
    val person: Person?,
    @SerializedName("self")
    val self: Boolean,
    @SerializedName("voice")
    val voice: Boolean
)