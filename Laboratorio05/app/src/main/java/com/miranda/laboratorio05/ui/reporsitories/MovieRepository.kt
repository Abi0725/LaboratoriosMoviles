package com.miranda.laboratorio05.ui.reporsitories

import com.miranda.laboratorio05.ui.data.models.Movie

class MovieRepository(private val movies: MutableList<Movie>) {

    fun getMovies() = movies

}