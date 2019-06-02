package com.niko.news.other

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.niko.news.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*


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

fun String.parseTimestamp(): Date {
    val dateFormat = SimpleDateFormat(TIMESTAMP, Locale.getDefault())
    return dateFormat.parse(this)
}

fun Date.formatArticleTime(): String {
    val dateFormat = SimpleDateFormat(ARTICLE_FORMAT, Locale.getDefault())
    return dateFormat.format(this)
}

fun Fragment.ending(number: Int, arrayRes: Int): String {

    val arrayEndings = resources.getStringArray(arrayRes)

    var selectedNumber = number

    val finalEnding: String
    val i: Int
    selectedNumber %= 100
    if (selectedNumber in 11..19) {
        finalEnding = arrayEndings[2]
    } else {
        i = selectedNumber % 10
        finalEnding = when (i) {
            1 -> arrayEndings[0]
            2, 3, 4 -> arrayEndings[1]
            else -> arrayEndings[2]
        }
    }
    return finalEnding
}
