package com.waichee.hiltpractice01.ui.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import com.waichee.hiltpractice01.data.repository.TmdbPagingDataSource
import com.waichee.hiltpractice01.data.repository.TmdbPagingDataSourceFactory
import com.waichee.hiltpractice01.utils.Resource
import com.waichee.hiltpractice01.utils.State

class MovieListViewModel @ViewModelInject constructor(
    private val tmdbPagingDataSourceFactory: TmdbPagingDataSourceFactory
) : ViewModel(){
    private val pageSize = 10

    var movies: LiveData<PagedList<Movie>>

    fun getState(): LiveData<State> = Transformations.switchMap(
        tmdbPagingDataSourceFactory.tmdbPagingDataSourceLiveData,
        TmdbPagingDataSource::state
    )

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        movies = LivePagedListBuilder(tmdbPagingDataSourceFactory, config).build()
    }
}