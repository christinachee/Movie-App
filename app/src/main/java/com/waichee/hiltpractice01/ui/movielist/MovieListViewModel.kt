package com.waichee.hiltpractice01.ui.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import com.waichee.hiltpractice01.data.repository.MovieRepository
import timber.log.Timber
import androidx.paging.PagedList
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import com.waichee.hiltpractice01.utils.Resource
import com.waichee.hiltpractice01.utils.TmdbPagingDataSource
import com.waichee.hiltpractice01.utils.TmdbPagingDataSourceFactory
import kotlinx.coroutines.Dispatchers

class MovieListViewModel @ViewModelInject constructor(
    private val repository: MovieRepository,
    private val remoteDataSource: MovieRemoteDataSource
) : ViewModel(){

    private val tmdbPagingDataSourceFactory: TmdbPagingDataSourceFactory
    private val pageSize = 5
    var movies: LiveData<PagedList<Movie>>

//    val movies = repository.getMovies(1)


    init {
        Timber.i("viewModel init")
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()

        tmdbPagingDataSourceFactory = TmdbPagingDataSourceFactory(remoteDataSource)
        movies = LivePagedListBuilder(tmdbPagingDataSourceFactory, config).build()
    }

}