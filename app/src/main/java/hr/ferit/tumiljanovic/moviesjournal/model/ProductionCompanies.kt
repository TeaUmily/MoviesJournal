package hr.ferit.tumiljanovic.moviesjournal.model

import com.google.gson.annotations.SerializedName


class ProductionCompanies(var id: String,
                          @SerializedName("origin_country") var originCountry: String,
                          @SerializedName("logo_path")  var logoPath: String,
                          var name: String)