package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_rating_stars

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper


class RatingStarsHolder(itemView: View, var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.movie_ratingBar)
    lateinit var ratingBar: RatingBar

    @BindView(R.id.movie_score)
    lateinit var movieScore: TextView

    @BindView(R.id.number_of_votes)
    lateinit var voteNumber : TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as RatingStarsHolderData
            ratingBar.rating = data.averageScore/2
            movieScore.text = data.averageScore.toString()
            voteNumber.text = data.getNumberOfVotesAsString()

        }
    }
}