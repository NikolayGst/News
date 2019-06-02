package com.niko.news.ui.main.news


import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.niko.news.R
import com.niko.news.other.TECHNOLOGY
import com.niko.news.other.annotations.LayoutResourceId
import com.niko.news.other.base.BaseFragment
import javax.inject.Inject

@LayoutResourceId(R.layout.fragment_news)
class NewsFragment : BaseFragment(), NewsView {

    @Inject
    @InjectPresenter
    lateinit var newsPresenter: NewsPresenter

    @ProvidePresenter
    fun provideNewsPresenter() = newsPresenter

    override fun renderView(view: View, savedInstanceState: Bundle?) {
        newsPresenter.getNewsByParam(TECHNOLOGY)
    }
}
