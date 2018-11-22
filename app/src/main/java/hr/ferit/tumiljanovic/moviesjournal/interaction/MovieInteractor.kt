package hr.ferit.tumiljanovic.moviesjournal.interaction

import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener

interface MovieInteractor {

    fun getMovie(listener: NetworkResponseListener, movieId : Int): Any

}