package com.niko.news.app.modules

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.niko.news.domain.dataProviders.local.LocalDataProvider
import com.niko.news.domain.dataProviders.local.LocalDataProviderImpl
import com.niko.news.domain.dataProviders.local.database.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("shared_pref_app", MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): Database {
        return Room
                .databaseBuilder(context, Database::class.java, "NewsDb")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideLocalDataProvider(
            sharedPreferences: SharedPreferences,
            database: Database
    ): LocalDataProvider {
        return LocalDataProviderImpl(sharedPreferences, database)
    }
}