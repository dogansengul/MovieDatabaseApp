package com.example.moviedatabase.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.api.MovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel() {

    fun getPopularMovies(): LiveData<List<MovieModel>> {
        val movies = MutableLiveData<List<MovieModel>>()
        viewModelScope.launch {
            movies.value = movieRepository.getPopularMovies()
        }
        return movies
    }


    fun getMockData(): ArrayList<MovieModel> {
        val movieResult1 = MovieModel(
            adult = false,
            backdrop_path = "/3tzPSJiCPqacAgRsMkMPof2ZinL.jpg",
            genre_ids = listOf(27, 53),
            id = 1008042,
            original_language = "en",
            original_title = "Talk to Me",
            overview = "When a group of friends discover how to conjure spirits using an embalmed hand, they become hooked on the new thrill, until one of them goes too far and unleashes terrifying supernatural forces.",
            popularity = 4755.68,
            poster_path = "/kdPMUMJzyYAc4roD52qavX0nLIC.jpg",
            release_date = "2023-07-26",
            title = "Talk to Me",
            video = false,
            vote_average = 7.2,
            vote_count = 569
        )

        val movieResult2 = MovieModel(
            adult = false,
            backdrop_path = "/4XM8DUTQb3lhLemJC51Jx4a2EuA.jpg",
            genre_ids = listOf(28, 80, 53),
            id = 385687,
            original_language = "en",
            original_title = "Fast X",
            overview = "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted, out-nerved and outdriven every foe in their path. Now, they confront the most lethal opponent they've ever faced: A terrifying threat emerging from the shadows of the past who's fueled by blood revenge, and who is determined to shatter this family and destroy everything—and everyone—that Dom loves, forever.",
            popularity = 3872.798,
            poster_path = "/fiVW06jE7z9YnO4trhaMEdclSiC.jpg",
            release_date = "2023-05-17",
            title = "Fast X",
            video = false,
            vote_average = 7.3,
            vote_count = 3714
        )

        val movieResult3 = MovieModel(
            adult = false,
            backdrop_path = "/4XM8DUTQb3lhLemJC51Jx4a2EuA.jpg",
            genre_ids = listOf(28, 80, 53),
            id = 385687,
            original_language = "en",
            original_title = "Fast X",
            overview = "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted, out-nerved and outdriven every foe in their path. Now, they confront the most lethal opponent they've ever faced: A terrifying threat emerging from the shadows of the past who's fueled by blood revenge, and who is determined to shatter this family and destroy everything—and everyone—that Dom loves, forever.",
            popularity = 3872.798,
            poster_path = "/fiVW06jE7z9YnO4trhaMEdclSiC.jpg",
            release_date = "2023-05-17",
            title = "Fast X",
            video = false,
            vote_average = 7.3,
            vote_count = 3714
        )
        return arrayListOf<MovieModel>(movieResult1, movieResult2, movieResult3)
    }
}