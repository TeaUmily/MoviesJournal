package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_overview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolderData
import kotlinx.android.synthetic.main.cell_overview.view.*

class OverviewHolder(itemView: View, var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.movie_overview)
    lateinit var overview: TextView


    init {
        ButterKnife.bind(this, itemView)
    }

    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as OverviewHolderData
            overview.text = data.overview

        }
    }

}