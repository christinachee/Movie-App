package com.waichee.hiltpractice01.utils

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource

class TmdbPagingDataSourceFactory constructor(
    private val remoteDataSource: MovieRemoteDataSource
): DataSource.Factory<Int, Movie>() {

    val tmdbPagingDataSourceLiveData = MutableLiveData<TmdbPagingDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val tmdbPagingDataSource = TmdbPagingDataSource(remoteDataSource)
        tmdbPagingDataSourceLiveData.postValue(tmdbPagingDataSource)
        return tmdbPagingDataSource
    }

}