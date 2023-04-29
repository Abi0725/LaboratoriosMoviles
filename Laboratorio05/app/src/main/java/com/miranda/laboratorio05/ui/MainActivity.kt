package com.miranda.laboratorio05.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.miranda.laboratorio05.R
import com.miranda.laboratorio05.ui.movie.MovieViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}