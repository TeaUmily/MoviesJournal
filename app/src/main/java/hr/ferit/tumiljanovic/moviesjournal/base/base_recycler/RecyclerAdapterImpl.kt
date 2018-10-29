package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler


import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_BACKDROP
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_POSTER
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.EmptyViewHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_poster.PosterHolder
import javax.inject.Inject

open class RecyclerAdapterImpl @Inject constructor() : RecyclerAdapter, RecyclerView.Adapter<ViewHolder>() {

    var dataList: MutableList<RecyclerWrapper> = mutableListOf()

    fun addItems(items: List<RecyclerWrapper>) {
        dataList.clear()
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            TYPE_BACKDROP -> BackdropHolder(view, dataList)
            TYPE_POSTER -> PosterHolder(view, dataList)
            else -> EmptyViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
            when (viewHolder.itemViewType) {
                TYPE_BACKDROP -> {
                    val holder: BackdropHolder = viewHolder as BackdropHolder
                    holder.onBind(position)
                }
                TYPE_POSTER -> {
                    val holder: PosterHolder = viewHolder as PosterHolder
                    holder.onBind(position)
                }
                else -> Unit
            }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }

}

