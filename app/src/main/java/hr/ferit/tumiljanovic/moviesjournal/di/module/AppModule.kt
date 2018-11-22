package hr.ferit.tumiljanovic.moviesjournal.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.App
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapterImpl
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresRecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.scopes.PerFragment
import java.util.HashMap
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


    @Provides
    internal fun provideSomeMap(): Map<String, Int> {
        return HashMap()
    }


    @Provides
    fun provideAdapter(): GenresRecyclerAdapter = GenresRecyclerAdapter()

}