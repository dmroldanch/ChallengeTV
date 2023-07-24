package com.tvmaze.challenge.domain.service

import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents

interface TVShowsNetworkDataSource {
    suspend fun getShowsSchedule(country: String, date: String): DomainResponse<List<Show>>
    suspend fun getschedulesByQuery(
        query: String,
        country: String,
        date: String
    ): DomainResponse<List<Show>>

    suspend fun getShowDetails(id: Int): DomainResponse<Show>
    suspend fun getShowTalens(id: Int): DomainResponse<List<Talents>>
}