package com.niko.news.ui.main.news

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.niko.news.domain.models.entities.ArticleModel

@StateStrategyType(SingleStateStrategy::class)
interface NewsView : MvpView {
    fun onSuccessGetCounts(map: Map<String, Int>)
    fun onSuccessGetArticlesByCategory(articles: List<ArticleModel>)
    fun onFailure(throwable: Throwable)
}