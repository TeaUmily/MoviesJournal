package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper


class BackdropHolder(itemView: View, var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.movie_backdrop)
    lateinit var backdropImage: ImageView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as BackdropHolderData
            Glide.with(backdropImage.getContext()).load(data.imagePath).into(backdropImage)
        }
    }

}