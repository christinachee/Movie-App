package com.waichee.hiltpractice01.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import com.waichee.hiltpractice01.databinding.FragmentMovieListBinding
import com.waichee.hiltpractice01.utils.Resource
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment: Fragment(), MovieListAdapter.MovieItemListener {
    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var adapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieListBinding.inflate(inflater)
        binding.viewModel = viewModel

        adapter = MovieListAdapter(this)
        binding.movieRv.adapter = adapter

        setupObservers()

        return binding.root
    }


    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(activity, "SUCCESS", Toast.LENGTH_SHORT).show()
                    Timber.i(it.data.toString())
                    adapter.submitList(it.data?.results)
                }
                Resource.Status.LOADING -> {
                    Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onClickedMovie(movie_id: Int) {
        Toast.makeText(activity, "$movie_id", Toast.LENGTH_SHORT).show()
        Timber.i("$movie_id is clicked")
    }
}