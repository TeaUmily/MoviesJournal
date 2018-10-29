package hr.ferit.tumiljanovic.moviesjournal.interaction

import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener

interface MovieListInteractor {

    fun getMovies(listener: NetworkResponseListener, movieCategory: String, page: Int): Any

}