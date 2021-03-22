package com.polippo.filmesflix.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.polippo.filmesflix.R
import com.polippo.filmesflix.model.Movie
import com.polippo.filmesflix.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()

        initObserver()
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            populateList(list)
        })
    }

    private fun populateList(list: List<Movie>){
        movieList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
}