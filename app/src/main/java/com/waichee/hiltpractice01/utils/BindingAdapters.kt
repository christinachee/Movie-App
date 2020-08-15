package com.waichee.hiltpractice01.utils

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import timber.log.Timber

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Picasso.get().load("https://image.tmdb.org/t/p/w500$imageUrl").into(imageView)
    }
}

@BindingAdapter("voteAverage")
fun bindVoteAverage(textView: TextView, voteAverage: Double?) {
    voteAverage?.let{
        when (it) {
            0.0 -> textView.text = "- -"
            else -> textView.text = it.toString()
        }
    }
}

@BindingAdapter("voteAverageStar")
fun bindVoteAverageStar(ratingBar: RatingBar, voteAverage: Double?) {
    voteAverage?.let {
        ratingBar.rating = (voteAverage/2).toFloat()
    }
}

