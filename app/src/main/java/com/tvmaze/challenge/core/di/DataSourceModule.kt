package com.tvmaze.challenge.core.di


import com.tvmaze.challenge.data.networkdatasource.CharacterDataSourceImp
import com.tvmaze.challenge.data.networkdatasource.EpisodesDataSourceImp
import com.tvmaze.challenge.domain.repository.IEpisodesRepository
import com.tvmaze.challenge.domain.service.ICharactersDataSource
import com.tvmaze.challenge.domain.service.IEpisodesDataSource
import com.tvmaze.challenge.domain.service.TVShowsNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideEpisodesNetworkSource(tvShowsNetworkDataSourceImp: EpisodesDataSourceImp): IEpisodesDataSource

    @Binds
    abstract fun provideCharactersNetworkSource(tvShowsNetworkDataSourceImp: CharacterDataSourceImp): ICharactersDataSource
}