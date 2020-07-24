package com.waichee.hiltpractice01.data.repository

import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import com.waichee.hiltpractice01.utils.performGetOperation
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
){
    fun getMovies() = performGetOperation(
        networkCall = { remoteDataSource.getMovies() }
    )
}