package hr.ferit.tumiljanovic.moviesjournal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.home.HomeActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.home.di.HomeActivityModule


@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    abstract fun provideHomeActivity(): HomeActivity


}