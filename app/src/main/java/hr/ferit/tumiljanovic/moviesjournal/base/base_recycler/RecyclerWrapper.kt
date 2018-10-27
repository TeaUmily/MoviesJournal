package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler

import hr.ferit.tumiljanovic.moviesjournal.R

class RecyclerWrapper(var type: Int) {

    companion object {
        const val TYPE_BACKDROP = R.layout.cell_movie_backdrop
    }

    var data: Any? = null

    constructor(data: Any, type: Int) : this(type)


}