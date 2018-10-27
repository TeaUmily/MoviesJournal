package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_BACKDROP
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.EmptyViewHolder

open class RecyclerAdapterImpl(var dataList: MutableList<RecyclerWrapper>, val context: Context) : RecyclerAdapter, RecyclerView.Adapter<ViewHolder>() {

    fun addItems(items: List<RecyclerWrapper>) {
        dataList.clear()
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            TYPE_BACKDROP -> BackdropHolder(view, dataList)
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
                else -> Unit
            }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }

}

