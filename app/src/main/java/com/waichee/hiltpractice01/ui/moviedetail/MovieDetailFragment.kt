package com.waichee.hiltpractice01.ui.moviedetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment: Fragment() {
    private val viewModel: MovieDetailViewModel by viewModels()
}