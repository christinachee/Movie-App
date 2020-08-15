package com.waichee.hiltpractice01.data.repository

import androidx.lifecycle.LiveData
import com.waichee.hiltpractice01.data.entities.MovieDetail
import com.waichee.hiltpractice01.data.entities.MovieList
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import com.waichee.hiltpractice01.utils.Resource
import com.waichee.hiltpractice01.utils.performGetOperation
import timber.log.Timber
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
){
    fun getMovie(movie_id: Int): LiveData<Resource<MovieDetail>> {
        Timber.i("getMovie called $movie_id")
        return performGetOperation(
            networkCall = {remoteDataSource.getMovie(movie_id)}
        )
    }
}