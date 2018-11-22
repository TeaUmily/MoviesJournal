package hr.ferit.tumiljanovic.moviesjournal.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Movie(var budget: Float,
                 @SerializedName("vote_average") var averageScore: Float,
                 @SerializedName("backdrop_path") var backdropImage: String,
                 @SerializedName("poster_path") var poster: String,
                 var genres: List<Genres>?,
                 var title: String?,
                 @SerializedName("vote_count") var numberOfVotes: Int,
                 var id: String,
                 @SerializedName("release_date") var releaseDate: String?,
                 var tagline: String?,
                 var overview: String?,
                 var runtime: String? = "0",
                 var homepage: String?,
                 @SerializedName("spoken_languages") var languages: List<SpokenLanguages>,
                 @SerializedName("production_countries")  var productionCountries: List<ProductionCountries>,
                 @SerializedName("production_companies") var productionCompanies : List<ProductionCompanies>



)

