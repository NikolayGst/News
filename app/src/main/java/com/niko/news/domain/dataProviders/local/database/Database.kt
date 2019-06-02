package com.niko.news.domain.dataProviders.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.niko.news.domain.models.entities.NewsModel

@Database(
        entities = [
            NewsModel::class
        ],
        version = 1,
        exportSchema = false)
abstract class Database : RoomDatabase() {

}