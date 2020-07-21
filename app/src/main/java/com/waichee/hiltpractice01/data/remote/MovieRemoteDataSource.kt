package com.waichee.hiltpractice01.data.remote

import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService) : BaseDataSource() {

    suspend fun getMovies() = getResult { movieService.getMovies()}

}