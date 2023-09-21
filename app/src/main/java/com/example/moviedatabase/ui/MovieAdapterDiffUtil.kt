package com.example.moviedatabase.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.api.MovieModel

class MovieAdapterDiffUtil(
    private val oldList: ArrayList<MovieModel>,
    private val newList: ArrayList<MovieModel>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].adult != newList[newItemPosition].adult -> false
            oldList[oldItemPosition].video != newList[newItemPosition].video -> false
            oldList[oldItemPosition].backdrop_path != newList[newItemPosition].backdrop_path -> false
            oldList[oldItemPosition].genre_ids != newList[newItemPosition].genre_ids -> false
            oldList[oldItemPosition].original_language != newList[newItemPosition].original_language -> false
            oldList[oldItemPosition].original_title != newList[newItemPosition].original_title -> false
            oldList[oldItemPosition].overview != newList[newItemPosition].overview -> false
            oldList[oldItemPosition].popularity != newList[newItemPosition].popularity -> false
            oldList[oldItemPosition].title != newList[newItemPosition].title -> false
            oldList[oldItemPosition].release_date != newList[newItemPosition].release_date -> false
            oldList[oldItemPosition].vote_average != newList[newItemPosition].vote_average -> false
            oldList[oldItemPosition].vote_count != newList[newItemPosition].vote_count -> false
            oldList[oldItemPosition].poster_path != newList[newItemPosition].poster_path -> false
            else -> true
        }
    }
}