package com.tvmaze.challenge.data.repository

import android.util.Log
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.domain.repository.IEpisodesRepository
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import com.tvmaze.challenge.domain.service.IEpisodesDataSource
import com.tvmaze.challenge.domain.service.TVShowsNetworkDataSource
import javax.inject.Inject

class EpisodesRepositoryImp @Inject constructor(
    private val networkDataSource: IEpisodesDataSource
) : IEpisodesRepository {

    override suspend fun getEpisodes(): DomainResponse<List<Episode>> {
        return try {
            networkDataSource.getEpisodes()
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }

    override suspend fun getEpisodesQuery(name: String): DomainResponse<Episode> {
        return try {
            networkDataSource.getEpisodesQuery(name)
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }

}