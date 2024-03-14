package com.tvmaze.challenge.domain.service

import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.episodes.Episode

interface IEpisodesDataSource {
    suspend fun getEpisodes(): DomainResponse<List<Episode>>

    suspend fun getEpisodesQuery(
        number: String,
    ): DomainResponse<Episode>
}