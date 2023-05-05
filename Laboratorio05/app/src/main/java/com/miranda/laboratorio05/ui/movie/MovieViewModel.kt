package com.miranda.laboratorio05.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miranda.laboratorio05.ui.MovieReviewerApplication
import com.miranda.laboratorio05.ui.data.models.Movie
import com.miranda.laboratorio05.ui.reporsitories.MovieRepository
class MovieViewModel(private val repository: MovieRepository) : ViewModel(){

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies() = repository.getMovies()

    fun addMovies(movie: Movie) = repository.addMovies(movie)

    fun createMovie(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val movie = Movie(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData():Boolean{
        when {
            name.value.isNullOrEmpty()-> return false
            category.value.isNullOrEmpty()-> return false
            description.value.isNullOrEmpty()-> return false
            qualification.value.isNullOrEmpty()-> return false
        }
        return true
    }

    private fun clearData(){
        name.value=""
        category.value=""
        description.value=""
        qualification.value=""
    }

   fun clearStatus(){
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}