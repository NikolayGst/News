package com.niko.news.ui.main.news


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.niko.news.R
import com.niko.news.domain.models.entities.ArticleModel
import com.niko.news.other.*
import com.niko.news.other.annotations.LayoutResourceId
import com.niko.news.other.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

@LayoutResourceId(R.layout.fragment_news)
class NewsFragment : BaseFragment(), NewsView {

    @Inject
    @InjectPresenter
    lateinit var newsPresenter: NewsPresenter

    @ProvidePresenter
    fun provideNewsPresenter() = newsPresenter

    override fun renderView(view: View, savedInstanceState: Bundle?) {
        lrBusiness.setOnClickListener { newsPresenter.getNewsByParam(BUSINESS) }
        lrSport.setOnClickListener { newsPresenter.getNewsByParam(SPORTS) }
        lrScience.setOnClickListener { newsPresenter.getNewsByParam(SCIENCE) }
        lrTech.setOnClickListener { newsPresenter.getNewsByParam(TECHNOLOGY) }
    }

    @SuppressLint("SetTextI18n")
    override fun onSuccessGetCounts(map: Map<String, Int>) {
        countBusinessArticles.text = "${map[BUSINESS]?: "-"} ${ending(map[BUSINESS]?:0, R.array.articles)}"
        countSportArticles.text = "${map[SPORTS]?: "-"} ${ending(map[SPORTS]?:0, R.array.articles)}"
        countScienceArticles.text = "${map[SCIENCE] ?: "-"} ${ending(map[SCIENCE]?:0, R.array.articles)}"
        countTechArticles.text = "${map[TECHNOLOGY]?: "-"} ${ending(map[TECHNOLOGY]?:0, R.array.articles)}"
    }

    override fun onSuccessGetArticlesByCategory(articles: List<ArticleModel>) {
        Toast.makeText(requireContext(), "onSuccess: ${articles.first().category}", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(throwable: Throwable) {
        showThrowableMessage(throwable)
    }
}
