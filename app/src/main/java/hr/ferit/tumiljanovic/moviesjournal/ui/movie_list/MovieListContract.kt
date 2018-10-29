package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list

import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper

interface MovieListContract {

    interface View {

        fun showMovies(recyclerWrapper: MutableList<RecyclerWrapper>)
    }

    interface Presenter {

        fun getMovies(position: Int)

    }

}