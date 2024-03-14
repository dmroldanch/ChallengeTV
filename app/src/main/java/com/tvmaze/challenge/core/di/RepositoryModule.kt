package com.tvmaze.challenge.core.di

import com.tvmaze.challenge.data.repository.CharactersRepositoryImp
import com.tvmaze.challenge.data.repository.EpisodesRepositoryImp
import com.tvmaze.challenge.data.repository.TVShowsRepositoryImp
import com.tvmaze.challenge.domain.repository.ICharactersRepository
import com.tvmaze.challenge.domain.repository.IEpisodesRepository
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideEpisodeRepository(tvShowsRepositoryImp: EpisodesRepositoryImp): IEpisodesRepository

    @Binds
    abstract fun provideCharactersRepository(tvShowsRepositoryImp: CharactersRepositoryImp): ICharactersRepository
}