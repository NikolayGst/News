package com.niko.news.domain.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
class NewsModel(
        @PrimaryKey
        val id: Int,
        val text: String
)