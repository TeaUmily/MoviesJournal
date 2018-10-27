package hr.ferit.tumiljanovic.moviesjournal.interaction

import hr.ferit.tumiljanovic.moviesjournal.api.ApiService
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieInteractorImpl(var apiService: ApiService) : MovieInteractor, BaseInteractor() {


    override fun getMovies(listener: NetworkResponseListener, movieCategory: String, page: Int) = when (movieCategory) {
        Constants.TYPE_POPULAR ->
            apiService.getPopularMovies(Constants.PAGE, Constants.LANGUAGE, Constants.API_KEY).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { it -> InteractorWrapper(it) }
                    .subscribe(provideDisposableObserver(listener))


        Constants.TYPE_UPCOMING ->
            apiService.getUpcomingMovies(Constants.PAGE, Constants.LANGUAGE, Constants.API_KEY).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { it -> InteractorWrapper(it) }
                    .subscribe(provideDisposableObserver(listener))


        Constants.TYPE_TOP_RATED ->
            apiService.getTopRatedMovies(Constants.PAGE, Constants.LANGUAGE, Constants.API_KEY).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { it -> InteractorWrapper(it) }
                    .subscribe(provideDisposableObserver(listener))


        else -> Unit
    }

}