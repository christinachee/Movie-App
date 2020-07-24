package com.waichee.hiltpractice01.ui.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.waichee.hiltpractice01.data.repository.MovieRepository
import timber.log.Timber

class MovieListViewModel @ViewModelInject constructor(
    private val repository: MovieRepository
) : ViewModel(){

    val movies = repository.getMovies()

    init {
        Timber.i("viewModel init")
    }
}