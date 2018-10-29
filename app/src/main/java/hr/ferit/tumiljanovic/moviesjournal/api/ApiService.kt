package hr.ferit.tumiljanovic.moviesjournal.api

import hr.ferit.tumiljanovic.moviesjournal.model.Movie
import hr.ferit.tumiljanovic.moviesjournal.model.MovieList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String,
                         @Query("language") language: String,
                         @Query("page") list: String):
            Observable<MovieList>

    @GET("/3/movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String,
                          @Query("language") language: String,
                          @Query("page") list: String):
            Observable<MovieList>

    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String,
                          @Query("language") language: String,
                          @Query("page") list: String):
            Observable<MovieList>
}