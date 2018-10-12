package hr.ferit.tumiljanovic.moviesjournal.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hr.ferit.tumiljanovic.moviesjournal.App
import hr.ferit.tumiljanovic.moviesjournal.di.module.ActivityModule
import hr.ferit.tumiljanovic.moviesjournal.di.module.AppModule
import hr.ferit.tumiljanovic.moviesjournal.ui.home.di.HomeActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class),
    (HomeActivityModule::class),
    (AppModule::class),
    (ActivityModule::class)])

interface AppComponent : AndroidInjector<Application> {
    fun inject(application: App)

}