package com.waichee.hiltpractice01.data.remote

import com.waichee.hiltpractice01.utils.API_KEY
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService) : BaseDataSource() {

    suspend fun getMovies(page: Int) = getResult { movieService.getMovies(API_KEY, page)}

    suspend fun getMovie(movie_id: Int) = getResult { movieService.getMovie(movie_id, API_KEY) }
}