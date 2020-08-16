package com.waichee.hiltpractice01.ui.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.waichee.hiltpractice01.data.entities.MovieDetail
import com.waichee.hiltpractice01.data.repository.MovieRepository
import com.waichee.hiltpractice01.utils.Resource
import timber.log.Timber

class MovieDetailViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _id = MutableLiveData<Int>()

    private val _movie = _id.switchMap { id ->
        movieRepository.getMovie(id)
    }
    val movie: LiveData<Resource<MovieDetail>> = _movie

    fun start(id: Int) {
        _id.value = id
    }
}