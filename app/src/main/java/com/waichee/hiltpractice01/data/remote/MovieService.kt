package com.waichee.hiltpractice01.data.remote

import com.waichee.hiltpractice01.data.entities.MovieDetail
import com.waichee.hiltpractice01.data.entities.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("trending/movie/day")
    suspend fun getMovies(@Query("api_key") key: String) : Response<MovieList>

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movie_id: Int, @Query("api_key") key: String): Response<MovieDetail>

}