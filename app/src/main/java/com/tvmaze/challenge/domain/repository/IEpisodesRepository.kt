package com.tvmaze.challenge.domain.repository

import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.model.show.Show


interface IEpisodesRepository {
    suspend fun getEpisodes(): DomainResponse<List<Episode>>

    suspend fun getEpisodesQuery(
        name: String,
    ): DomainResponse<Episode>

}