package com.tvmaze.challenge.data.model.show.general


import com.google.gson.annotations.SerializedName

data class Show(
    @SerializedName("averageRuntime")
    val averageRuntime: Int,
    @SerializedName("dvdCountry")
    val dvdCountry: Any,
    @SerializedName("ended")
    val ended: Any,
    @SerializedName("externals")
    val externals: Externals,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("language")
    val language: String,
    @SerializedName("_links")
    val links: LinksX,
    @SerializedName("name")
    val name: String,
    @SerializedName("network")
    val network: Network,
    @SerializedName("officialSite")
    val officialSite: String,
    @SerializedName("premiered")
    val premiered: String,
    @SerializedName("rating")
    val rating: RatingX,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("schedule")
    val schedule: Schedule,
    @SerializedName("status")
    val status: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated")
    val updated: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("webChannel")
    val webChannel: WebChannel,
    @SerializedName("weight")
    val weight: Int
)