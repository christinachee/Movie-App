package com.waichee.hiltpractice01.ui.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MovieListViewModel @ViewModelInject constructor() : ViewModel(){

    init {
        Timber.i("viewModel init")
    }
}