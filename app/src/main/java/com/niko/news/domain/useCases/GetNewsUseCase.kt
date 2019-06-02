package com.niko.news.domain.useCases

import com.niko.news.domain.models.dataModels.GetNewsDataModel
import com.niko.news.domain.repository.Repository
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class GetNewsUseCase
@Inject
constructor(private val repository: Repository) {
    fun createObservable(arg: GetNewsDataModel?): Observable<Response<ResponseBody>> {
        return repository.getNews(arg!!)
    }
}