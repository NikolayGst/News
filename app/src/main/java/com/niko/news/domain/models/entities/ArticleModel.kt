package com.niko.news.domain.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleModel(
        @PrimaryKey
        val title: String,
        val author: String?,
        val description: String?,
        val url: String,
        val urlToImage: String?,
        val publishedAt: String,
        val category: String
)