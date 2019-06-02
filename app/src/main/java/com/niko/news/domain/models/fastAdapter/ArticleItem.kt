package com.niko.news.domain.models.fastAdapter

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.niko.news.R
import com.niko.news.domain.models.entities.ArticleModel
import com.niko.news.domain.models.fastAdapter.ArticleItem.ViewHolder
import com.niko.news.other.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleItem(private val article: ArticleModel) : AbstractItem<ArticleItem, ViewHolder>() {

    override fun getType() = ARTICLE_ITEM_ID

    override fun getLayoutRes() = R.layout.article_item

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(private val view: View) : FastAdapter.ViewHolder<ArticleItem>(view) {

        override fun bindView(item: ArticleItem, payloads: List<Any>) {
            view.title.text = item.article.title
            view.subtitle.text = getCategoryName(item)
            view.date.text = item.article.publishedAt.parseTimestamp().formatArticleTime()
            Picasso.get()
                    .load(item.article.urlToImage)
                    .centerCrop()
                    .resizeDimen(R.dimen.article_preview_size, R.dimen.article_preview_size)
                    .into(view.image)
        }

        private fun getCategoryName(item: ArticleItem): String {
            return view.context.getString(when(item.article.category) {
                BUSINESS -> R.string.business_text
                SPORTS -> R.string.sport_text
                SCIENCE -> R.string.science_text
                else -> R.string.tech_text
            })
        }

        override fun unbindView(item: ArticleItem) {
            view.title.text = null
            view.subtitle.text = null
            view.date.text = null
            view.image.setImageDrawable(null)
        }
    }
}