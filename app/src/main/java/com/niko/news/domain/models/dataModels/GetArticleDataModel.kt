package com.niko.news.domain.models.dataModels

data class GetArticleDataModel(
   val category: String,
   val page: Int = 1,
   val country: String = "ru",
   val pageSize: Int = 50
)