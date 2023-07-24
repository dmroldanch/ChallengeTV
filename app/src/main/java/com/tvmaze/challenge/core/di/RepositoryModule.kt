package com.tvmaze.challenge.core.di

import com.tvmaze.challenge.data.repository.TVShowsRepositoryImp
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideTvShowsRepository(tvShowsRepositoryImp: TVShowsRepositoryImp): TVShowsRepository
}