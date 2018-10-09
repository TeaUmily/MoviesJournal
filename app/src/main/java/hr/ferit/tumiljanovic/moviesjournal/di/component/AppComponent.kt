package hr.ferit.tumiljanovic.moviesjournal.di.component

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hr.ferit.tumiljanovic.moviesjournal.App
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class)])

interface AppComponent : AndroidInjector<Application> {
    fun inject(application: App)

}