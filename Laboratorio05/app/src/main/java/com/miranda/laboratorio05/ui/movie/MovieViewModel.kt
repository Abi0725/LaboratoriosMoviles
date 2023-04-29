package com.miranda.laboratorio05.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miranda.laboratorio05.ui.data.moviesDatabse
import com.miranda.laboratorio05.ui.reporsitories.MovieRepository

class MovieViewModel(private var repository: MovieRepository): ViewModel() {
    fun getMovies () = repository.getMovies()
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val repository = MovieRepository(moviesDatabse)
                MovieViewModel(repository)
            }
        }
    }
}