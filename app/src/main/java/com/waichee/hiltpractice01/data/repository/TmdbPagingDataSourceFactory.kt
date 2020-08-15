package com.waichee.hiltpractice01.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import com.waichee.hiltpractice01.data.repository.TmdbPagingDataSource
import javax.inject.Inject

class TmdbPagingDataSourceFactory @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
): DataSource.Factory<Int, Movie>() {

    val tmdbPagingDataSourceLiveData = MutableLiveData<TmdbPagingDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val tmdbPagingDataSource =
            TmdbPagingDataSource(
                remoteDataSource
            )
        tmdbPagingDataSourceLiveData.postValue(tmdbPagingDataSource)
        return tmdbPagingDataSource
    }

}