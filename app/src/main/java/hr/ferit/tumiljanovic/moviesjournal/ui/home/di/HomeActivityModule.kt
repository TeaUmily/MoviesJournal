package hr.ferit.tumiljanovic.moviesjournal.ui.home.di

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerActivity
import hr.ferit.tumiljanovic.moviesjournal.ui.home.HomeActivity


@Module
class HomeActivityModule {
    
    @PerActivity
    @Provides
    fun provideHomeView(homeActivity: HomeActivity): HomeActivity = homeActivity


}