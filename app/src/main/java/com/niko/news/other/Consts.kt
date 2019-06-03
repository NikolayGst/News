package com.niko.news.other

import com.niko.news.domain.models.entities.ArticleModel

const val BUSINESS = "business"
const val SPORTS = "sports"
const val SCIENCE = "science"
const val TECHNOLOGY = "technology"

const val TIMESTAMP = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val ARTICLE_FORMAT = "yyyy.MM.dd 'в' HH:mm"

const val ARTICLE_ITEM_ID = 1

typealias Articles = List<ArticleModel>