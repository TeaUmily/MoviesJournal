package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler

import hr.ferit.tumiljanovic.moviesjournal.R

class RecyclerWrapper(var data: Any, var type: Int) {

    companion object {
        const val TYPE_BACKDROP = R.layout.cell_movie_backdrop
        const val TYPE_POSTER = R.layout.cell_movie_poster
    }

}