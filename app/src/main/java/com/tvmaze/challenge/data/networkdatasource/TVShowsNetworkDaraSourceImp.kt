package com.tvmaze.challenge.data.networkdatasource

import com.tvmaze.challenge.data.mapper.querytoDomainModel
import com.tvmaze.challenge.data.mapper.toDomainModel
import com.tvmaze.challenge.data.networkdatasource.service.TVShowsService
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.domain.service.TVShowsNetworkDataSource
import javax.inject.Inject

class TVShowsNetworkDaraSourceImp @Inject constructor(private val service: TVShowsService): TVShowsNetworkDataSource {
    override suspend fun getShowsSchedule(country: String , date: String): DomainResponse<List<Show>> {
        val response = service.getShows(country,date)
        return DomainResponse.Success(response.map { show -> show.toDomainModel() })
    }

    override suspend fun getschedulesByQuery(query: String,country: String , date: String): DomainResponse<List<Show>> {
        val response = service.getShowsByQuery(query,country,date)
        return DomainResponse.Success(response.map { show -> show.querytoDomainModel() })
    }

    override suspend fun getShowDetails(id: Int): DomainResponse<Show> {
        val response = service.getShowDetails(id)
        return DomainResponse.Success(response.toDomainModel())
    }

    override suspend fun getShowTalens(id: Int): DomainResponse<List<Talents>> {
        val response = service.getShowTalents(id)
        return DomainResponse.Success(response.map { show -> show.toDomainModel() })
    }
}