package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_poster

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolderData

class PosterHolder(itemView: View, var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.movie_poster)
    lateinit var posterImage: ImageView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as PosterHolderData
            Glide.with(posterImage.getContext()).load(data.imagePath).into(posterImage)
        }
    }


}