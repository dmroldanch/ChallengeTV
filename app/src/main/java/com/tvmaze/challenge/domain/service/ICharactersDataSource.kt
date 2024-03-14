package com.tvmaze.challenge.domain.service

import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.show.Show

interface ICharactersDataSource {
    suspend fun getCharacter(): DomainResponse<List<Character>>

    suspend fun getCharacterQuery(
        name: String,
    ): DomainResponse<List<Character>>
}