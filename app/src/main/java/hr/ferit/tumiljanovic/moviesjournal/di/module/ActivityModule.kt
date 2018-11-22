package hr.ferit.tumiljanovic.moviesjournal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.home.HomeActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.home.di.HomeActivityModule
import hr.ferit.tumiljanovic.moviesjournal.ui.single.SingleActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.single.di.SingleActivityModule


@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    abstract fun provideHomeActivity(): HomeActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(SingleActivityModule::class))
    abstract fun provideSingleActivity(): SingleActivity




}