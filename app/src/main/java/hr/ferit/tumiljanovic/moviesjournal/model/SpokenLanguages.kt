package hr.ferit.tumiljanovic.moviesjournal.model

import com.google.gson.annotations.SerializedName

class SpokenLanguages(@SerializedName("iso_639_1")var language_id: String, var name:  String)