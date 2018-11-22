package hr.ferit.tumiljanovic.moviesjournal.ui.single

import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper

interface SingleActivityContract {

    interface View {
        fun getMovie()
        fun showMovie(recyclerWrapper: MutableList<RecyclerWrapper>)
    }

    interface Presenter {

        fun getMovieById(id: Int)
    }

}