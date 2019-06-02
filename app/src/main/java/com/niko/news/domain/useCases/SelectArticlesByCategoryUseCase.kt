package com.niko.news.domain.useCases

import com.niko.news.domain.models.entities.ArticleModel
import com.niko.news.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class SelectArticlesByCategoryUseCase
@Inject
constructor(
        private val repository: Repository
) : BaseUseCase<String, List<ArticleModel>>() {
    override fun createObservable(arg: String?): Observable<List<ArticleModel>> {
        return repository.selectArticlesByCategory(arg!!)
    }
}