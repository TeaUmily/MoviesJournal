package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_genres

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.App
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper

import hr.ferit.tumiljanovic.moviesjournal.utils.divider_item_decorator.HorizontalItemDivider
import javax.inject.Inject


class GenresHolder : RecyclerView.ViewHolder {

    var item: View

    var dataList: List<RecyclerWrapper>


    @BindView(R.id.genres_recyclerview)
    lateinit var recycler: RecyclerView


    @Inject
    lateinit var adapter: GenresRecyclerAdapter


    constructor(view: View, data :List<RecyclerWrapper> ) : super(view) {
        this.dataList = data
        item = view

        ButterKnife.bind(this, itemView)
    }


    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val data = dataList[position].data as GenresHolderData


            App.instance.appComponent.inject(this)

            recycler.layoutManager = LinearLayoutManager(App.instance, LinearLayoutManager.HORIZONTAL, false)
            recycler.itemAnimator = DefaultItemAnimator()
            recycler.addItemDecoration(HorizontalItemDivider())
            recycler.adapter = adapter
            adapter.addItems(data.genres!!)

        }
    }
}

