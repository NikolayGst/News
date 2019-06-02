package com.niko.news.app.modules

import com.niko.news.domain.dataProviders.global.GlobalDataProvider
import com.niko.news.domain.dataProviders.local.LocalDataProvider
import com.niko.news.domain.repository.Repository
import com.niko.news.domain.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
            @Named("API_KEY")
            apiKey: String,
            globalDataProvider: GlobalDataProvider,
            localDataProvider: LocalDataProvider
    ): Repository {
        return RepositoryImpl(apiKey, globalDataProvider, localDataProvider)
    }
}