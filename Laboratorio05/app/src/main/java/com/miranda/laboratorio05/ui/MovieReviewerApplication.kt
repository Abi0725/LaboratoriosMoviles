package com.miranda.laboratorio05.ui

import android.app.Application
import com.miranda.laboratorio05.ui.data.movies
import com.miranda.laboratorio05.ui.reporsitories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}