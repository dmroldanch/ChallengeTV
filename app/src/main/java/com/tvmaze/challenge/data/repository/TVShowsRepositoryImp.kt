package com.tvmaze.challenge.data.repository

import android.util.Log
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import com.tvmaze.challenge.domain.service.TVShowsNetworkDataSource
import javax.inject.Inject

class TVShowsRepositoryImp @Inject constructor(
    private val networkDataSource: TVShowsNetworkDataSource
) : TVShowsRepository {

    override suspend fun getschedules(country: String, date: String): DomainResponse<List<Show>> {
        return try {
            networkDataSource.getShowsSchedule(country, date)
        } catch (e: Exception) {
            DomainResponse.OnFailure(e.toString())
        }
    }

    override suspend fun getschedulesByQuery(
        name: String,
        country: String,
        date: String
    ): DomainResponse<List<Show>> {
        return try {
            networkDataSource.getschedulesByQuery(name, country, date)
        } catch (e: Exception) {
            DomainResponse.OnFailure(e.toString())
        }
    }

    override suspend fun getShowDetails(id: Int): DomainResponse<Show> {
        return try {
            networkDataSource.getShowDetails(id)
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }

    override suspend fun getShowTalens(id: Int): DomainResponse<List<Talents>> {
        return try {
            networkDataSource.getShowTalens(id)
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }

}