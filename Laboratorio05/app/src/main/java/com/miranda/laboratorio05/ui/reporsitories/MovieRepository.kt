package com.miranda.laboratorio05.ui.reporsitories

import com.miranda.laboratorio05.ui.data.models.Movie

class MovieRepository() {
    private var movies = mutableListOf(
        Movie("Batman: The Dark Knight","Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker."),
        Movie("Blade Runner 2049","Thirty   years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what's left of society into chaos. K's discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.")
    )

    fun getMovies() = movies
}