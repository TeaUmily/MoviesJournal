package hr.ferit.tumiljanovic.moviesjournal.ui.single.di

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapterImpl
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresRecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieInteractor
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieInteractorImpl
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieListInteractor
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieListInteractorImpl
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListContract
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListFragment
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListPresenter
import hr.ferit.tumiljanovic.moviesjournal.ui.single.SingleActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.single.SingleActivityContract
import hr.ferit.tumiljanovic.moviesjournal.ui.single.SinglePresenter

@Module
class SingleActivityModule {

    @PerActivity
    @Provides
    fun provideSingleActivityView(singleActivity: SingleActivity): SingleActivityContract.View = singleActivity

    @PerActivity
    @Provides
    fun provideMovieInteractor(interactor: MovieInteractorImpl): MovieInteractor {
        // fragment.getLifecycle().addObserver(interactor)
        return interactor
    }

    @PerActivity
    @Provides
    fun provideSinglePresenter(presenter: SinglePresenter): SingleActivityContract.Presenter = presenter

}