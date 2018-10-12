package hr.ferit.tumiljanovic.moviesjournal.listener

import hr.ferit.tumiljanovic.moviesjournal.interaction.InteractorWrapper

interface NetworkResponseListener {

    fun onSuccess(callback: InteractorWrapper)
    fun onFailure(throwable: Throwable)

}