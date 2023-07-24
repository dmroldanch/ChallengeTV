package com.tvmaze.challenge.data.networkdatasource.service

import com.tvmaze.challenge.data.model.show.detail.ShowDetailDTO
import com.tvmaze.challenge.data.model.show.general.TvGeneralDataDTO
import com.tvmaze.challenge.data.model.show.talent.TalentDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowsService {
    @GET("schedule")
    suspend fun getShows(@Query("country") country : String, @Query("date")  date : String): List<TvGeneralDataDTO>

    @GET("search/shows")
    suspend fun getShowsByQuery(@Query("q") query : String,@Query("country") country : String, @Query("date")  date : String): List<TvGeneralDataDTO>

    @GET("shows/{id}")
    suspend fun getShowDetails(@Path("id") query : Int): ShowDetailDTO

    @GET("shows/{id}/cast")
    suspend fun getShowTalents(@Path("id") query : Int): List<TalentDTO>
}