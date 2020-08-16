package com.waichee.hiltpractice01.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.waichee.hiltpractice01.R
import dagger.hilt.android.AndroidEntryPoint
import com.waichee.hiltpractice01.databinding.FragmentMovieListBinding
import com.waichee.hiltpractice01.utils.Resource
import com.waichee.hiltpractice01.utils.State
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment: Fragment(), MovieListAdapter.MovieItemListener {
    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var adapter: MovieListAdapter
    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater)
        binding.viewModel = viewModel

        adapter = MovieListAdapter(this)
        binding.movieRv.adapter = adapter

        setupObservers()
        initState()

        return binding.root
    }


    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun initState() {
        viewModel.getState().observe(viewLifecycleOwner, Observer {
            when (it) {
                State.SUCCESS -> {
                    binding.movieRv.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
                State.LOADING -> {
                    binding.movieRv.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                else -> Toast.makeText(activity, "State.ERROR", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClickedMovie(movie_id: Int) {
        Timber.i("$movie_id is clicked")
        this.findNavController().navigate(
            R.id.action_movieListFragment_to_movieDetailFragment,
            bundleOf("movie_id" to movie_id)
        )
    }
}