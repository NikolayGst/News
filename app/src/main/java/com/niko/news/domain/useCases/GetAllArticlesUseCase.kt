package com.niko.news.domain.useCases

import com.niko.news.domain.models.dataModels.GetArticleDataModel
import com.niko.news.domain.models.entities.ArticleModel
import com.niko.news.domain.repository.Repository
import com.niko.news.other.BUSINESS
import com.niko.news.other.SCIENCE
import com.niko.news.other.SPORTS
import com.niko.news.other.TECHNOLOGY
import io.reactivex.Observable
import io.reactivex.functions.Function4
import javax.inject.Inject

typealias Articles = List<ArticleModel>

class GetAllArticlesUseCase
@Inject
constructor(
        private val repository: Repository
) : BaseUseCase<Unit, Boolean>() {
    override fun createObservable(arg: Unit?): Observable<Boolean> {
        return repository.removeAllArticles()
                .flatMap {
                    Observable.zip(
                            repository.getArticles(GetArticleDataModel(BUSINESS)),
                            repository.getArticles(GetArticleDataModel(SPORTS)),
                            repository.getArticles(GetArticleDataModel(SCIENCE)),
                            repository.getArticles(GetArticleDataModel(TECHNOLOGY)),
                            Function4 { t1: Articles, t2: Articles, t3: Articles, t4: Articles ->
                                t1.union(t2).union(t3).union(t4).toList()
                            }
                    )
                }.flatMap {
                    repository.saveArticles(it)
                }
    }
}