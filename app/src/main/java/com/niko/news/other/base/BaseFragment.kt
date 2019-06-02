package com.niko.news.other.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.niko.news.other.annotations.LayoutResourceId
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment : MvpAppCompatFragment() {

    private val compositeDisposable = CompositeDisposable()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = null
        val layoutResourceId = javaClass.getAnnotation(LayoutResourceId::class.java)
        if (layoutResourceId != null) {
            view = inflater.inflate(layoutResourceId.value, container, false)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderView(view, savedInstanceState)
    }

    abstract fun renderView(view: View, savedInstanceState: Bundle?)

    /**
     * Метод для сохранения подписок в коллекцию
     */
    fun Disposable.tracked() {
        compositeDisposable.add(this)
    }

    /**
     * Если есть подписки, отписываем их
     */
    private fun unsubscribeAll() {
        //Log.v("Отписываемся от подписок: " + compositeDisposable.size())
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unsubscribeAll()
    }

}