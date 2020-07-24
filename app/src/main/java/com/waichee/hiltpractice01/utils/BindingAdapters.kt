package com.waichee.hiltpractice01.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Picasso.get().load("https://image.tmdb.org/t/p/w500$imageUrl").into(imageView)
    }
}