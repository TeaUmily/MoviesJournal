package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler


import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_ABOUT_MOVIE
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_BACKDROP
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_GENRES
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_OVERVIEW
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_POSTER
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_RATING_STARS
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper.Companion.TYPE_TITLE_AND_RUNTIME
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.EmptyViewHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.about_movie.AboutMovieHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres.GenresRecyclerAdapter
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_overview.OverviewHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_poster.PosterHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_rating_stars.RatingStarsHolder
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_title_and_runtime.TitleAndRuntimeHolder
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
            TYPE_RATING_STARS -> RatingStarsHolder(view, dataList)
            TYPE_TITLE_AND_RUNTIME -> TitleAndRuntimeHolder(view, dataList)
            TYPE_GENRES -> GenresHolder(view, dataList)
            TYPE_OVERVIEW -> OverviewHolder(view, dataList)
            TYPE_ABOUT_MOVIE -> AboutMovieHolder(view, dataList)
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
                TYPE_RATING_STARS -> {
                    val holder: RatingStarsHolder = viewHolder as RatingStarsHolder
                    holder.onBind(position)
                }
                TYPE_TITLE_AND_RUNTIME -> {
                    val holder: TitleAndRuntimeHolder = viewHolder as TitleAndRuntimeHolder
                    holder.onBind(position)
                }
                TYPE_GENRES -> {
                    val holder: GenresHolder = viewHolder as GenresHolder
                    holder.onBind(position)
                }
                TYPE_OVERVIEW -> {
                    val holder: OverviewHolder = viewHolder as OverviewHolder
                    holder.onBind(position)
                }
                TYPE_ABOUT_MOVIE ->{
                    val holder: AboutMovieHolder = viewHolder as AboutMovieHolder
                    holder.onBind(position)
                }
                else -> Unit
            }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }

}

