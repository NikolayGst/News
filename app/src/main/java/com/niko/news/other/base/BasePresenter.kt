package com.niko.news.other.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<T : MvpView> : MvpPresenter<T>() {

    private val compositeDisposable = CompositeDisposable()

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
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.isDisposed
            compositeDisposable.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unsubscribeAll()
    }

}