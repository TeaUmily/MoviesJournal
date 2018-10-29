package hr.ferit.tumiljanovic.moviesjournal.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    private lateinit var context: Context

    fun AppModule(context: Context){
        this.context = context
    }

    @Provides
    fun context(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideApp() = app

}