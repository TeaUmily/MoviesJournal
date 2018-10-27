package hr.ferit.tumiljanovic.moviesjournal.di.module

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    fun provideApp() = app

}