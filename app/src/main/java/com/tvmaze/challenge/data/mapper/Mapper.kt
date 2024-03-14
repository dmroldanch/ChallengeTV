package com.tvmaze.challenge.data.mapper

import com.tvmaze.challenge.core.utils.cleanTextWithHtmlTags
import com.tvmaze.challenge.data.model.character.CharacterData
import com.tvmaze.challenge.data.model.character.CharacterDetailDTO
import com.tvmaze.challenge.data.model.episodes.EpisodeDetailDTO
import com.tvmaze.challenge.data.model.show.detail.ShowDetailDTO
import com.tvmaze.challenge.data.model.show.general.TvGeneralDataDTO
import com.tvmaze.challenge.data.model.show.talent.TalentDTO
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents


fun CharacterDetailDTO.toDomain() : Character {

    return Character(
        created =  this.created,
        gender = this.gender,
        id = this.id,
        image = this.image,
        name = this.name,
        species = this.species,
        status = this.status,
        type = this.type,
        url = this.url
    )
}

fun EpisodeDetailDTO.toDomain() : Episode {

    return Episode(
        airDate = this.airDate,
        created = this.created,
        episode = this.episode,
        id = this.id,
        name = this.name,
        url = this.url
    )
}