package com.niko.news.domain.repository

import com.niko.news.domain.dataProviders.global.GlobalDataProvider
import com.niko.news.domain.dataProviders.local.LocalDataProvider

class RepositoryImpl(
        private val globalDataProvider: GlobalDataProvider,
        private val localDataProvider: LocalDataProvider
) : Repository {
}