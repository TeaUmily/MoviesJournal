package hr.ferit.tumiljanovic.moviesjournal.model

import com.google.gson.annotations.SerializedName

class ProductionCountries(var name: String, @SerializedName("iso_3166_1") var productionId: String )