package com.tvmaze.challenge.core.utils

import java.text.SimpleDateFormat
import java.util.Calendar

fun getDateFromToday(): String {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(calendar.time)
}