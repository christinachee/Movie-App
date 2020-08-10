package com.waichee.hiltpractice01.data.remote

import com.waichee.hiltpractice01.utils.API_KEY
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService) : BaseDataSource() {

    suspend fun getMovies() = getResult { movieService.getMovies("d7edc25efdda8e8ca81a58e7cc18c654")}

    suspend fun getMovie(movie_id: Int) = getResult { movieService.getMovie(movie_id, "d7edc25efdda8e8ca81a58e7cc18c654") }

}