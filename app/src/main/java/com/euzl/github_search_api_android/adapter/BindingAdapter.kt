package com.euzl.github_search_api_android.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("date")
fun bindOrderTime(view: TextView, date: Date?) {
    if (date == null) return
    val dateFormat = SimpleDateFormat("d MMM yy")
    dateFormat.timeZone = TimeZone.getTimeZone("Seoul/Asia")

    view.text = "Updated on ${dateFormat.format(date)}"
}

@BindingAdapter("descriptionVisible")
fun bindDescription(view: TextView, description: String?) {
    if (description == null) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
        view.text = description
    }
}