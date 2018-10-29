package hr.ferit.tumiljanovic.moviesjournal.interaction

import hr.ferit.tumiljanovic.moviesjournal.api.ApiService
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import hr.ferit.tumiljanovic.moviesjournal.model.MovieList
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieListInteractorImpl @Inject constructor(private var apiService: ApiService) : MovieListInteractor, BaseInteractor() {


    override fun getMovies(listener: NetworkResponseListener, movieCategory: String, page: Int) = when (movieCategory) {
        Constants.TYPE_POPULAR ->
            apiService.getPopularMovies(Constants.API_KEY, Constants.LANGUAGE, Constants.PAGE)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { t: MovieList ->  InteractorWrapper(t) }
                    .subscribe(provideDisposableObserver(listener))


        Constants.TYPE_UPCOMING ->
            apiService.getUpcomingMovies(Constants.API_KEY, Constants.LANGUAGE, Constants.PAGE)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { t: MovieList ->  InteractorWrapper(t) }
                    .subscribe(provideDisposableObserver(listener))


        Constants.TYPE_TOP_RATED ->
            apiService.getTopRatedMovies(Constants.API_KEY, Constants.LANGUAGE, Constants.PAGE)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { t: MovieList ->  InteractorWrapper(t) }
                    .subscribe(provideDisposableObserver(listener))


        else -> Unit
    }
}