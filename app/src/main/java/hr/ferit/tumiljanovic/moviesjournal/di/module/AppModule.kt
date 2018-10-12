package hr.ferit.tumiljanovic.moviesjournal.di.module

import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.App
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    internal fun provideContext(): App {
        return app
    }

}