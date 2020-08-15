package com.waichee.hiltpractice01.data.repository

import android.content.Context
import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.data.remote.MovieRemoteDataSource
import com.waichee.hiltpractice01.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class TmdbPagingDataSource @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) : PageKeyedDataSource<Int, Movie>() {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        scope.launch {
            try {
                val response = remoteDataSource.getMovies(1)
                when (response.status) {
                    Resource.Status.SUCCESS -> callback.onResult(response.data!!.results,
                        null, 2)
                    else -> Timber.i("Status not success")
                }
            }catch (e: Exception) {
                Timber.e(e)
            }
        }

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        scope.launch {
            try {
                val response = remoteDataSource.getMovies(params.key)
                when (response.status) {
                    Resource.Status.SUCCESS -> callback.onResult(response.data!!.results, params.key +1)
                    else -> Timber.i("Status not success")
                }
            }catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        scope.launch {
            try {
                val response = remoteDataSource.getMovies(params.key)
                when (response.status) {
                    Resource.Status.SUCCESS -> callback.onResult(response.data!!.results, params.key-1)
                    else-> Timber.i("Status not success")
                }
            }catch (e: Error) {
                Timber.e(e)
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }

}