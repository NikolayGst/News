package com.niko.news.other.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.niko.news.other.annotations.LayoutResourceId
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject



abstract class BaseActivity : MvpAppCompatActivity(), HasSupportFragmentInjector {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val layoutResourceId = javaClass.getAnnotation(LayoutResourceId::class.java)
        if (layoutResourceId != null) {
            setContentView(layoutResourceId.value)
        }
        renderView(savedInstanceState)
    }

    protected abstract fun renderView(savedInstanceState: Bundle?)

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
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unsubscribeAll()
    }

}