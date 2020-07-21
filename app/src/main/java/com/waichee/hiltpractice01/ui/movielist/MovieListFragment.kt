package com.waichee.hiltpractice01.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.waichee.hiltpractice01.databinding.FragmentMovieListBinding

@AndroidEntryPoint
class MovieListFragment: Fragment() {
    private val viewModel: MovieListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieListBinding.inflate(inflater)
        binding.viewModel = viewModel

        return binding.root
    }
}