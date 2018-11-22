package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.model.Genres
import javax.inject.Inject

class GenresRecyclerAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var dataList: MutableList<Genres> = mutableListOf()


    fun addItems(items: List<Genres>) {
        dataList.clear()
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_gener, parent, false)
        return GenreViewHolder(view, dataList)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        val holder: GenreViewHolder = viewHolder as GenreViewHolder
        holder.onBind(position)
    }

    class GenreViewHolder(view: View, var dataList: MutableList<Genres>) : RecyclerView.ViewHolder(view) {

        @BindView(R.id.movie_genre)
        lateinit var genre: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun onBind(position: Int) {
            if (position != RecyclerView.NO_POSITION) {
                val data = dataList[position].name
                genre.text = data
            }
        }
    }

}