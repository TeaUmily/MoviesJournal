package hr.ferit.tumiljanovic.moviesjournal.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hr.ferit.tumiljanovic.moviesjournal.App
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresHolderData
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresRecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.di.module.ActivityModule
import hr.ferit.tumiljanovic.moviesjournal.di.module.AppModule
import hr.ferit.tumiljanovic.moviesjournal.di.module.FragmentModule
import hr.ferit.tumiljanovic.moviesjournal.di.module.ServiceModule
import hr.ferit.tumiljanovic.moviesjournal.ui.home.di.HomeActivityModule
import hr.ferit.tumiljanovic.moviesjournal.ui.single.di.SingleActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class),
    (HomeActivityModule::class),
    (AppModule::class),
    (ServiceModule::class),
    (ActivityModule::class),
    (FragmentModule::class),
    (SingleActivityModule::class)])

interface AppComponent : AndroidInjector<Application> {
    fun inject(app: App)

    fun inject(genresHolder: GenresHolder)

}