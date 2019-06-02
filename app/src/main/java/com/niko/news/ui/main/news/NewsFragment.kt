package com.niko.news.ui.main.news


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.niko.news.R
import com.niko.news.domain.models.entities.ArticleModel
import com.niko.news.domain.models.fastAdapter.ArticleItem
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

    private lateinit var fastAdapter: FastAdapter<ArticleItem>
    private lateinit var itemAdapter: ItemAdapter<ArticleItem>

    override fun renderView(view: View, savedInstanceState: Bundle?) {
        setupCategoryButtons()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        itemAdapter = ItemAdapter()
        fastAdapter = FastAdapter.with(itemAdapter)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = fastAdapter
        }
    }

    private fun setupCategoryButtons() {
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
        itemAdapter.clear()
        itemAdapter.add(articles.map { ArticleItem(it) })
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onFailure(throwable: Throwable) {
        showThrowableMessage(throwable)
    }
}
