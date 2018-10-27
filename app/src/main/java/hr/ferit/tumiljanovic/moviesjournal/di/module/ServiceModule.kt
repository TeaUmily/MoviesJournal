package hr.ferit.tumiljanovic.moviesjournal.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hr.ferit.tumiljanovic.moviesjournal.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
public class ServiceModule {

    private val BASE_URL = "http://api.themoviedb.org/"


    @Singleton
    @Provides
    fun apiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor()).build()
    }

    @Singleton
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.excludeFieldsWithoutExposeAnnotation()
        return gsonBuilder.create()
    }
}
