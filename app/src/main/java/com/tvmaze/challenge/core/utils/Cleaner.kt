package com.tvmaze.challenge.core.utils

import android.os.Build
import androidx.core.text.HtmlCompat

fun String.cleanTextWithHtmlTags(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
    } else {
        HtmlCompat.fromHtml(this,0).toString()
    }
}