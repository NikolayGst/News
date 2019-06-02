package com.niko.news.domain.useCases

import com.niko.news.domain.repository.Repository
import com.niko.news.other.*
import io.reactivex.Observable
import io.reactivex.functions.Function4
import javax.inject.Inject

class SelectCountsByCategoryUseCase
@Inject
constructor(
        private val repository: Repository
) : BaseUseCase<Unit, Map<String, Int>>() {
    override fun createObservable(arg: Unit?): Observable<Map<String, Int>> {
        return Observable.zip(
                repository.selectArticlesByCategory(BUSINESS).take(1),
                repository.selectArticlesByCategory(SPORTS).take(1),
                repository.selectArticlesByCategory(SCIENCE).take(1),
                repository.selectArticlesByCategory(TECHNOLOGY).take(1),
                Function4 { t1: Articles, t2: Articles, t3: Articles, t4: Articles ->
                    mapOf(
                            BUSINESS to t1.size,
                            SPORTS to t2.size,
                            SCIENCE to t3.size,
                            TECHNOLOGY to t4.size
                    )
                }
        )
    }
}