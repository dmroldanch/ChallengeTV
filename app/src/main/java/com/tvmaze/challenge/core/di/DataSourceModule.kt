package com.tvmaze.challenge.core.di


import com.tvmaze.challenge.data.networkdatasource.TVShowsNetworkDaraSourceImp
import com.tvmaze.challenge.domain.service.TVShowsNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideTVShowsNetworkSource(tvShowsNetworkDataSourceImp: TVShowsNetworkDaraSourceImp): TVShowsNetworkDataSource
}