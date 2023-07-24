package com.tvmaze.challenge.domain.model.show


data class Show(
    val id: Int = 0,
    val name: String = "",
    val network: String = "",
    val image: String = "",
    val airdate: String = "",
    val airtime: String = "",
    val synopsis: String = "",
    val genres: String = "",
    val linkSite: String = "",
    val rating: String = "",
)