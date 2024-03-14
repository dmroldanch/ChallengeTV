package com.tvmaze.challenge.data.repository

import android.util.Log
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.domain.repository.ICharactersRepository
import com.tvmaze.challenge.domain.repository.IEpisodesRepository
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import com.tvmaze.challenge.domain.service.ICharactersDataSource
import com.tvmaze.challenge.domain.service.IEpisodesDataSource
import com.tvmaze.challenge.domain.service.TVShowsNetworkDataSource
import javax.inject.Inject

class CharactersRepositoryImp @Inject constructor(
    private val networkDataSource: ICharactersDataSource
) : ICharactersRepository {


    override suspend fun getCharacters(): DomainResponse<List<Character>> {
        return try {
            networkDataSource.getCharacter()
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }

    override suspend fun getCharactersQuery(name: String): DomainResponse<List<Character>> {
        return try {
            networkDataSource.getCharacterQuery(name)
        } catch (e: Exception) {
            Log.e("Exception Repository", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }

}