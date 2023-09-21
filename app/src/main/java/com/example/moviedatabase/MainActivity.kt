package com.example.moviedatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviedatabase.api.MovieModel
import com.example.moviedatabase.databinding.ActivityMainBinding
import com.example.moviedatabase.model.MainViewModel
import com.example.moviedatabase.model.MainViewModelFactory
import com.example.moviedatabase.model.MovieRepository
import com.example.moviedatabase.ui.MovieAdapter
import com.example.moviedatabase.ui.SpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var data: ArrayList<MovieModel>
    @Inject lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRV()
        viewModel = MainViewModelFactory(repository).create(MainViewModel::class.java)

        viewModel.getPopularMovies().observe(this@MainActivity) {
            data = ArrayList(it)
            movieAdapter.submitNewData(ArrayList(it))
        }

    }

    private fun setUpRV() = binding.rvMovieRecyclerView.apply {
        movieAdapter = MovieAdapter()
        adapter = movieAdapter
        movieAdapter.setItemClickListener(object : MovieAdapter.OnClickListener{
            override fun onClick(position: Int) {
                Toast.makeText(this@MainActivity, "Clicked $position", Toast.LENGTH_SHORT).show()
            }
        })
        layoutManager = GridLayoutManager(this@MainActivity, 2)
        addItemDecoration(SpacingItemDecoration(25))
    }
}