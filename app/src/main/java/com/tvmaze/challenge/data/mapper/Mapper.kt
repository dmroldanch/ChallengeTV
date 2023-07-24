package com.tvmaze.challenge.data.mapper

import com.tvmaze.challenge.core.utils.cleanTextWithHtmlTags
import com.tvmaze.challenge.data.model.show.detail.ShowDetailDTO
import com.tvmaze.challenge.data.model.show.general.TvGeneralDataDTO
import com.tvmaze.challenge.data.model.show.talent.TalentDTO
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents


fun TvGeneralDataDTO.toDomainModel(): Show {
    return Show(
        id = this.show?.id ?: 0,
        name = this.show?.name ?: "",
        network =this.show?.network?.name  ?: "",
        image = this.show?.image?.medium  ?: "",
        airdate = this.airdate  ?: "",
        airtime =this.airtime ?: "" ,
    )

}

fun TvGeneralDataDTO.querytoDomainModel(): Show {

    val days = this.show?.schedule?.days?.joinToString(",") ?: ""

    return Show(
        id = this.show?.id ?: 0,
        name = this.show?.name ?: "",
        network =this.show?.network?.name  ?: "",
        image = this.show?.image?.medium  ?: "",
        airdate = days ,
        airtime =this.show?.schedule?.time  ?: "" ,
    )

}


fun ShowDetailDTO.toDomainModel(): Show {

    return Show(
        id = this.id,
        name = this.name,
        network =this.network.name,
        image = this.image?.medium ?: "",
        airdate = this.schedule.days.joinToString(",") ,
        airtime = this.schedule.time,
        synopsis = this.summary?.cleanTextWithHtmlTags() ?: "",
        genres = this.genres?.joinToString(",") ?: "",
        linkSite =  this.officialSite?.toString() ?: "",
        rating = this.rating?.average.toString()
    )
}

fun TalentDTO.toDomainModel(): Talents {
    return Talents(
        image = this.person?.image?.medium ?: "",
        name = this.person?.name ?: ""
    )
}