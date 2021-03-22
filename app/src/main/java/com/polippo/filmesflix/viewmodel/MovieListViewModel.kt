package com.polippo.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polippo.filmesflix.api.MovieRestApiTask
import com.polippo.filmesflix.model.Movie
import com.polippo.filmesflix.repository.MovieRepository

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask =  MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){

        Thread{
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (e: Exception){
                Log.d(TAG, e.message.toString())
            }
        }.start()


    }
}