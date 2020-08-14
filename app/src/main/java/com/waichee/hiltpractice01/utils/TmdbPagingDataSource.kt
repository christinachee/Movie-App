package com.waichee.hiltpractice01.utils

import android.content.Context
import androidx.paging.PageKeyedDataSource
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class TmdbPagingDataSource constructor(
    private val remoteDataSource: MovieRemoteDataSource
) : PageKeyedDataSource<Int, Movie>() {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        Timber.i("loadInitial")
        scope.launch {
            callback.onResult(
                remoteDataSource.getMovies(1).data!!.results,
                null,
                2)
        }

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        scope.launch {
            Timber.i("loadAfter")
            callback.onResult(
                remoteDataSource.getMovies(params.key).data!!.results,
                params.key +1
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        Timber.i("loadBefore")
        scope.launch {
            callback.onResult(
                remoteDataSource.getMovies(params.key).data!!.results,
                params.key -1
            )
        }
    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }

}