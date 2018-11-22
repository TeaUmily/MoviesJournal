package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_title_and_runtime

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper


class TitleAndRuntimeHolder(itemView: View, var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.movie_title)
    lateinit var movieTitle: TextView

    @BindView(R.id.movie_runtime)
    lateinit var movieRuntime: TextView

    init {
        ButterKnife.bind(this, itemView)
    }


    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as TitleAndRuntimeHolderData
            movieTitle.text = data.title
            movieRuntime.text = data.getRuntimeAsString()

        }
    }

}