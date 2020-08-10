package com.waichee.hiltpractice01.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import timber.log.Timber

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    Timber.i("bindImage")
    imageUrl?.let {
        Picasso.get().load("https://image.tmdb.org/t/p/w500$imageUrl").into(imageView)
    }
}

