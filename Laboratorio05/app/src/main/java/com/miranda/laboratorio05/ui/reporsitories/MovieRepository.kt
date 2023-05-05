package com.miranda.laboratorio05.ui.reporsitories

import com.miranda.laboratorio05.ui.data.models.Movie

class MovieRepository(private val movies: MutableList<Movie>) {

    fun getMovies() = movies

    // add a new movie to the list of movies dummyData.kt
    fun addMovies(movie: Movie) = movies.add(movie)


}