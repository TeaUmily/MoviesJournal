package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list

import hr.ferit.tumiljanovic.moviesjournal.interaction.InteractorWrapper
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieInteractor
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import hr.ferit.tumiljanovic.moviesjournal.model.Movie
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants

class MovieListPresenter(private var movieInteractor: MovieInteractor,
                         private var view: MovieListContract.View) : MovieListContract.Presenter, NetworkResponseListener {
    override fun setView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


     override fun getMovies() {
        movieInteractor.getMovies(this, Constants.TYPE_POPULAR, 1)

    }

    override fun onSuccess(callback: InteractorWrapper) {
      var callbackMovieList : List<Movie> = callback.data as List<Movie>

    }

    override fun onFailure(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}