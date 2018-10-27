package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list

interface MovieListContract {

    interface View {

    }

    interface Presenter {

        fun getMovies()

        fun setView()
    }

}