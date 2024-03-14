package com.tvmaze.challenge.domain.repository

import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.model.show.Show


interface ICharactersRepository {
    suspend fun getCharacters(): DomainResponse<List<Character>>

    suspend fun getCharactersQuery(
        name: String,
    ): DomainResponse<List<Character>>

}