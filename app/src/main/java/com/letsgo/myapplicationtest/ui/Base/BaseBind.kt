package com.letsgo.myapplicationtest.ui.Base

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:glideBackground")
fun glideBackground(imageView: ImageView, url: String?) {
    url?.run {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}

@BindingAdapter("app:timeFormat")
fun timeFormat(textView: TextView, timeFormat: Long?) {
    if (timeFormat == null) {
        textView.visibility =  View.GONE
    } else {
        val sdf = SimpleDateFormat("MM dd, yyyy HH:mm aa", Locale.ENGLISH)
        val str = sdf.format(timeFormat *1000)
        textView.text = str
    }
}
