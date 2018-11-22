package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.about_movie


import hr.ferit.tumiljanovic.moviesjournal.model.ProductionCompanies
import hr.ferit.tumiljanovic.moviesjournal.model.ProductionCountries
import hr.ferit.tumiljanovic.moviesjournal.model.SpokenLanguages
import kotlin.text.StringBuilder


class AboutMovieHolderData(var budget: Float, var languages: List<SpokenLanguages>, var productionCountries: List<ProductionCountries>, var productionCompanies: List<ProductionCompanies>, var homepage: String?, var releaseDate: String?) {


    var stringBuilder = StringBuilder()


    fun GetBudgetWithValute():String{
        return budget.toBigDecimal().toPlainString() + " $"
    }


    fun getLanguagesConnected(): String {

        stringBuilder.setLength(0)

        for (SpokenLanguage in languages) {
            while (SpokenLanguage != languages.last()) {
                stringBuilder.append(SpokenLanguage.name + ", ")
            }
        }

        stringBuilder.append(languages.last().name)

        return stringBuilder.toString()

    }

    fun getCountriesConnected(): String {

        stringBuilder.setLength(0)

        for (ProductionCountries in productionCountries) {
            while (ProductionCountries != productionCountries.last()) {
                stringBuilder.append(ProductionCountries.name + ", ")
            }
        }

        stringBuilder.append(productionCountries.last().name)
        return stringBuilder.toString()

    }

    fun getCompaniesConnected(): String {


        stringBuilder.setLength(0)

        for (ProductionCompanies in productionCompanies) {
            if (ProductionCompanies != productionCompanies.last()) {
                stringBuilder.append(ProductionCompanies.name + ", ")
            }
        }
        stringBuilder.append(productionCompanies.last().name)

        return stringBuilder.toString()

    }


}