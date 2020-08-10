package com.waichee.hiltpractice01.ui.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.waichee.hiltpractice01.data.entities.Movie
import com.waichee.hiltpractice01.databinding.ItemMovieBinding

class MovieListAdapter constructor(private val listener: MovieItemListener) :
    ListAdapter<Movie, MovieListAdapter.MovieVH>(DiffCallback) {

    interface MovieItemListener {
        fun onClickedMovie(movie_id: Int)
    }

    class MovieVH(
        private var binding: ItemMovieBinding,
        private val listener: MovieItemListener
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private lateinit var movie: Movie

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            this.movie = movie
            binding.movie = movie
            binding.executePendingBindings()
        }

        override fun onClick(v: View?) {
            listener.onClickedMovie(movie_id = movie.id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return MovieVH(binding, listener)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }
}