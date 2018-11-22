package hr.ferit.tumiljanovic.moviesjournal.interaction

import android.provider.SyncStateContract
import hr.ferit.tumiljanovic.moviesjournal.api.ApiService
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import hr.ferit.tumiljanovic.moviesjournal.model.Movie
import hr.ferit.tumiljanovic.moviesjournal.model.MovieList
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieInteractorImpl @Inject constructor(private var apiService: ApiService) : BaseInteractor(), MovieInteractor {

    override fun getMovie(listener: NetworkResponseListener, movieId: Int): Any =
        apiService.getMovieDetails(movieId, Constants.API_KEY, Constants.LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { t: Movie ->  InteractorWrapper(t) }
                .subscribe(provideDisposableObserver(listener))

}