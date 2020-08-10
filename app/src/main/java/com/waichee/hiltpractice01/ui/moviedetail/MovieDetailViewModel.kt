package com.waichee.hiltpractice01.ui.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.waichee.hiltpractice01.data.repository.MovieRepository

class MovieDetailViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    val movie = movieRepository.getMovie(521034)
}