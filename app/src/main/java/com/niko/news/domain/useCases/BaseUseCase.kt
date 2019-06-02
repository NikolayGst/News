package com.niko.news.domain.useCases

import io.reactivex.Observable

abstract class BaseUseCase<Argument, Result> {
    abstract fun createObservable(arg: Argument? = null): Observable<Result>
}