package com.niko.news.domain.models.dataModels

data class GetNewsDataModel(
   val category: String,
   val page: Int,
   val country: String = "ru"
)