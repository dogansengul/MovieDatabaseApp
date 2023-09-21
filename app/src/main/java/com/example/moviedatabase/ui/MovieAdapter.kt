package com.example.moviedatabase.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.api.Constants
import com.example.moviedatabase.api.MovieModel
import com.example.moviedatabase.databinding.LayoutMovieItemRowBinding

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieData: ArrayList<MovieModel> = ArrayList()
    private var mlistener: OnClickListener? = null

    interface OnClickListener {
        fun onClick(position: Int)
    }

    fun setItemClickListener(onClickListener: OnClickListener) {
        mlistener = onClickListener
    }

    inner class MovieViewHolder(private val binding: LayoutMovieItemRowBinding, listener: OnClickListener?): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                listener?.onClick(adapterPosition)
            }
        }
        fun bind(movie: MovieModel) {
            binding.tvMovieTitle.text = movie.title

            Glide.with(binding.root.context)
                .load(Constants.MOVIE_PATH.plus(movie.poster_path))
                .centerCrop()
                .into(binding.ivPosterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutMovieItemRowBinding.inflate(LayoutInflater.from(parent.context)), mlistener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    fun submitNewData(newData: ArrayList<MovieModel>) {
        val diffUtil = MovieAdapterDiffUtil(movieData, newData )
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        movieData.clear()
        movieData.addAll(newData)
        diffResults.dispatchUpdatesTo(this)
    }
}