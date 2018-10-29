package hr.ferit.tumiljanovic.moviesjournal.model


import com.google.gson.annotations.SerializedName

data class MovieList( @SerializedName("results") val movies: List<Movie>,
                      val page: String)