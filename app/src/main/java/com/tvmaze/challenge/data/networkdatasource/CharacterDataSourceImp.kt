package com.tvmaze.challenge.data.networkdatasource

import android.util.Log
import com.tvmaze.challenge.data.mapper.toDomain
import com.tvmaze.challenge.data.networkdatasource.service.TVShowsService
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.service.ICharactersDataSource
import com.tvmaze.challenge.domain.service.IEpisodesDataSource
import javax.inject.Inject

class CharacterDataSourceImp @Inject constructor(private val service: TVShowsService): ICharactersDataSource {

    override suspend fun getCharacter(): DomainResponse<List<Character>> {
        val response = service.getCharacter()
        return if(response.isSuccessful){
            DomainResponse.Success(response.body()?.results?.map { character -> character.toDomain() } ?: emptyList())
        } else {
            DomainResponse.OnFailure(response.errorBody().toString())
        }

    }

    override suspend fun getCharacterQuery(name: String): DomainResponse<List<Character>> {
        val response = service.getCharacterSearch(name)
        return try {
            return if(response.isSuccessful) {
                DomainResponse.Success(response.body()?.results?.map { character -> character.toDomain() }
                    ?: emptyList())
            } else {
                DomainResponse.OnFailure(response.errorBody().toString())
            }
        } catch (e: Exception) {
            Log.e("Exception Query", e.message.toString())
            DomainResponse.OnFailure(e.toString())
        }
    }
}