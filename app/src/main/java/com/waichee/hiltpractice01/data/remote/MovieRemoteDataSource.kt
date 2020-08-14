package com.waichee.hiltpractice01.data.remote

import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService) : BaseDataSource() {

    suspend fun getMovies(page: Int) = getResult { movieService.getMovies("d7edc25efdda8e8ca81a58e7cc18c654", page)}

    suspend fun getMovie(movie_id: Int) = getResult { movieService.getMovie(movie_id, "d7edc25efdda8e8ca81a58e7cc18c654") }
}