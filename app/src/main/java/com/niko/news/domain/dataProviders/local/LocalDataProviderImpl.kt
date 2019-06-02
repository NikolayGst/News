package com.niko.news.domain.dataProviders.local

import android.content.SharedPreferences
import com.niko.news.domain.dataProviders.local.database.Database

class LocalDataProviderImpl(
        private val sharedPreferences: SharedPreferences,
        private val database: Database
) : LocalDataProvider {
}