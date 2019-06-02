package com.niko.news.other

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.niko.news.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T : Any> Observable<T>.async(): Observable<T> {
    return this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
}

fun Fragment.showThrowableMessage(throwable: Throwable) {
    val dialog = AlertDialog.Builder(requireContext())
            .setMessage(throwable.message)
            .setPositiveButton(R.string.ok, null)
            .create()
    dialog.show()
}
