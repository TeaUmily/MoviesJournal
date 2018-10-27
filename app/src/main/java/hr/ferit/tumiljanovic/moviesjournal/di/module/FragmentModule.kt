package hr.ferit.tumiljanovic.moviesjournal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListFragment
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.di.MovieListFragmentModule

@Module
abstract class FragmentModule {

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(MovieListFragmentModule::class))
    abstract fun provideMoiveListFragment(): MovieListFragment


}