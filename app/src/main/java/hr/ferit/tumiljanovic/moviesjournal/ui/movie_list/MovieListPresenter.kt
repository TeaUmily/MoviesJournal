package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list

import android.util.Log
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_poster.PosterHolderData
import hr.ferit.tumiljanovic.moviesjournal.interaction.InteractorWrapper
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieListInteractor
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import hr.ferit.tumiljanovic.moviesjournal.model.MovieList
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants
import javax.inject.Inject

class MovieListPresenter @Inject constructor(private var movieInteractor: MovieListInteractor,
                                             private var view: MovieListContract.View) : MovieListContract.Presenter, NetworkResponseListener {


    override fun getMovies(position: Int) {
        when (position) {
            0 -> movieInteractor.getMovies(this, Constants.TYPE_UPCOMING, 1)
            1 -> movieInteractor.getMovies(this, Constants.TYPE_TOP_RATED, 1)
            2 -> movieInteractor.getMovies(this, Constants.TYPE_POPULAR, 1)
        }

    }

    override fun onSuccess(callback: InteractorWrapper) {

        var dataList: MutableList<RecyclerWrapper> = mutableListOf()

        var movieList: MovieList = callback.data as MovieList

        for (i in 0 until movieList.movies.size) {
            var recyclerWrapper: RecyclerWrapper = RecyclerWrapper(PosterHolderData(Constants.IMAGE_BASE_URL + movieList.movies[i].poster), RecyclerWrapper.TYPE_POSTER)
            dataList.add(recyclerWrapper)
        }

        view.showMovies(dataList)
    }

    override fun onFailure(throwable: Throwable) {

    }

}