package com.niko.news.domain.models.responseModels

import com.niko.news.domain.models.entities.ArticleModel

data class ArticlesWrapperModel(
        val status: String,
        val totalResults: Int,
        val articles: List<ArticleModel>
)