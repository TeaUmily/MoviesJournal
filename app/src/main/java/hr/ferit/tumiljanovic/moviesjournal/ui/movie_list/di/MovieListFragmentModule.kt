package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.di

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapterImpl
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieListInteractor
import hr.ferit.tumiljanovic.moviesjournal.interaction.MovieListInteractorImpl
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListContract
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListFragment
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListPresenter


@Module
class MovieListFragmentModule {

    @PerFragment
    @Provides
    fun provideRecyclerAdapter(adapter: RecyclerAdapterImpl): RecyclerAdapter = adapter

    @PerFragment
    @Provides
    fun provideRecyclerAdapterImpl() : RecyclerAdapterImpl = RecyclerAdapterImpl()

    @PerFragment
    @Provides
    fun provideMovieListView (fragment: MovieListFragment) : MovieListContract.View = fragment

    @PerFragment
    @Provides
    fun provideMovieListInteractor (interactor: MovieListInteractorImpl, fragment: MovieListFragment) : MovieListInteractor{
       // fragment.getLifecycle().addObserver(interactor)
        return interactor
    }

    @PerFragment
    @Provides
    fun provideMovieListPresenter (presenter : MovieListPresenter) : MovieListContract.Presenter = presenter

    @PerFragment
    @Provides
    fun provideFragmentManager (fragment: MovieListFragment) : FragmentManager = fragment.childFragmentManager

}