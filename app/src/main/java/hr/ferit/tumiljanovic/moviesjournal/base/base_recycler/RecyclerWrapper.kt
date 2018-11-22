package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler

import hr.ferit.tumiljanovic.moviesjournal.R

class RecyclerWrapper(var data: Any, var type: Int) {

    companion object {
        const val TYPE_BACKDROP = R.layout.cell_movie_backdrop
        const val TYPE_POSTER = R.layout.cell_movie_poster
        const val TYPE_TITLE_AND_RUNTIME = R.layout.cell_title_runtime
        const val TYPE_RATING_STARS = R.layout.cell_stars
        const val TYPE_GENRES = R.layout.cell_genres
        const val TYPE_OVERVIEW = R.layout.cell_overview
        const val TYPE_ABOUT_MOVIE = R.layout.cell_about

    }

}