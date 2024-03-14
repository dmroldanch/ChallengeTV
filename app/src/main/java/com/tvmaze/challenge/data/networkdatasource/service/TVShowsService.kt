package com.tvmaze.challenge.data.networkdatasource.service

import com.tvmaze.challenge.data.model.character.CharacterData
import com.tvmaze.challenge.data.model.character.CharacterDetailDTO
import com.tvmaze.challenge.data.model.episodes.EpisodeDetailDTO
import com.tvmaze.challenge.data.model.episodes.EpisodesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowsService {
    @GET("character")
    suspend fun getCharacter(): Response<CharacterData>

    @GET("character/")
    suspend fun getCharacterSearch(@Query("name") name : String): Response<CharacterData>


    @GET("episode")
    suspend fun getEpisodes(): Response<EpisodesData>

    @GET("episode/{episodeNumber}")
    suspend fun getEpisodesSearch(@Path("episodeNumber") episodeNumber : String): Response<EpisodeDetailDTO>

}