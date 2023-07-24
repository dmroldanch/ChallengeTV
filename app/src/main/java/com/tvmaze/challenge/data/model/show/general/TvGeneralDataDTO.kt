package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class TvGeneralDataDTO(
    @SerializedName("airdate")
    val airdate: String?,
    @SerializedName("airstamp")
    val airstamp: String?,
    @SerializedName("airtime")
    val airtime: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("season")
    val season: Int?,
    @SerializedName("show")
    val show: Show?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)