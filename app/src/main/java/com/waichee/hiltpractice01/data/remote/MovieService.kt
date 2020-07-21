package com.waichee.hiltpractice01.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("trending/movie/day")
    fun getMovies() : Response<MovieList>
}