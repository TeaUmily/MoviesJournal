package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.about_movie

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper


class AboutMovieHolder(itemView: View, var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {


    @BindView(R.id.movie_release_date)
    lateinit var releaseDate: TextView

    @BindView(R.id.movie_languages)
    lateinit var languages: TextView

    @BindView(R.id.movie_companies)
    lateinit var companies: TextView

    @BindView(R.id.movie_countries)
    lateinit var countries: TextView

    @BindView(R.id.movie_budget)
    lateinit var budget: TextView

    @BindView(R.id.movie_homepage)
    lateinit var homepage: TextView


    init {
        ButterKnife.bind(this, itemView)
    }


    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as AboutMovieHolderData
            budget.text = data.GetBudgetWithValute()
            homepage.text = data.homepage
            releaseDate.text = data.releaseDate
            languages.text = data.getLanguagesConnected()
            companies.text = data.getCompaniesConnected()
            countries.text = data.getCountriesConnected()
        }
    }
}