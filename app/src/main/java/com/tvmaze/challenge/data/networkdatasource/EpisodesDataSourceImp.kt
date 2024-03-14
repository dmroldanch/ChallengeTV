package com.tvmaze.challenge.data.networkdatasource

import com.tvmaze.challenge.data.mapper.toDomain
import com.tvmaze.challenge.data.networkdatasource.service.TVShowsService
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.service.IEpisodesDataSource
import javax.inject.Inject

class EpisodesDataSourceImp @Inject constructor(private val service: TVShowsService): IEpisodesDataSource {

    override suspend fun getEpisodes(): DomainResponse<List<Episode>> {
        val response = service.getEpisodes()
        return DomainResponse.Success(response.body()?.results?.map { episode -> episode.toDomain() } ?: emptyList())
    }

    override suspend fun getEpisodesQuery(name: String): DomainResponse<Episode> {
        val response = service.getEpisodesSearch(name)
        return DomainResponse.Success(response.body()?.toDomain() ?: Episode())
    }
}