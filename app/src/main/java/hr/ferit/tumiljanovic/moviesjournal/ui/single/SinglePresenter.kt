package hr.ferit.tumiljanovic.moviesjournal.ui.single
import android.widget.Toast
import hr.ferit.tumiljanovic.moviesjournal.App
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.about_movie.AboutMovieHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_overview.OverviewHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_rating_stars.RatingStarsHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_title_and_runtime.TitleAndRuntimeHolderData
import hr.ferit.tumiljanovic.moviesjournal.interaction.InteractorWrapper
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieInteractor
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import hr.ferit.tumiljanovic.moviesjournal.model.Movie
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants
import javax.inject.Inject

class SinglePresenter @Inject constructor(private var moveInteractor: MovieInteractor,
                                          private var view: SingleActivityContract.View) : SingleActivityContract.Presenter, NetworkResponseListener {


    override fun getMovieById(id: Int) {
        moveInteractor.getMovie(this, id)
    }


    override fun onSuccess(callback: InteractorWrapper) {
        var movie: Movie = callback.data as Movie
        var dataList: MutableList<RecyclerWrapper> = mutableListOf()

        dataList.add(RecyclerWrapper(BackdropHolderData(Constants.IMAGE_BASE_URL + movie.backdropImage, movie.tagline),RecyclerWrapper.TYPE_BACKDROP))
        dataList.add(RecyclerWrapper(TitleAndRuntimeHolderData(movie.title, movie.runtime?.toInt()), RecyclerWrapper.TYPE_TITLE_AND_RUNTIME))
        dataList.add(RecyclerWrapper(GenresHolderData(movie.genres), RecyclerWrapper.TYPE_GENRES))
        dataList.add(RecyclerWrapper(RatingStarsHolderData(movie.averageScore,movie.numberOfVotes),RecyclerWrapper.TYPE_RATING_STARS))
        dataList.add(RecyclerWrapper(OverviewHolderData(movie.overview), RecyclerWrapper.TYPE_OVERVIEW))
        dataList.add(RecyclerWrapper(AboutMovieHolderData(movie.budget, movie.languages, movie.productionCountries, movie.productionCompanies, movie.homepage, movie.releaseDate), RecyclerWrapper.TYPE_ABOUT_MOVIE))
        view.showMovie(dataList)

    }

    override fun onFailure(throwable: Throwable) {
        Toast.makeText(App.instance, "konekcija nije uspjela", Toast.LENGTH_SHORT)

    }

}