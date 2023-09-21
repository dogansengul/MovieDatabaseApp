package com.example.moviedatabase.model

import android.util.Log
import com.example.moviedatabase.api.Constants
import com.example.moviedatabase.api.MovieApi
import com.example.moviedatabase.api.MovieModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    suspend fun getPopularMovies(): List<MovieModel> {

        var movies = listOf<MovieModel>()
        withContext(IO) {
            try {
                val response = movieApi.getPopularMovies(Constants.apiKey)
                if (response.isSuccessful && response.body() != null) {
                    movies =  response.body()!!.results
                } else {
                    Log.d("Hata", "Null response body or unsuccesful response.")
                    return@withContext
                }
            } catch (e: HttpException) {
                Log.d("Hata", "unexpected response")
                return@withContext
            } catch (e: IOException) {
                Log.d("Hata", "Internet connection error.")
                return@withContext
            }
        }
        return movies
    }


}
