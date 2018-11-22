package hr.ferit.tumiljanovic.moviesjournal.ui.single

import android.os.Bundle
import android.support.v7.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.BaseActivity
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapterImpl
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import javax.inject.Inject


class SingleActivity : BaseActivity(), SingleActivityContract.View {


    @BindView(R.id.single_recycler)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var adapter: RecyclerAdapterImpl
    @Inject
    lateinit var presenter: SinglePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        ButterKnife.bind(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter


        this.getMovie()
    }


    override fun getMovie() {
       presenter.getMovieById(22)
    }

    override fun showMovie(data: MutableList<RecyclerWrapper>) {
       adapter.addItems(data)
    }
}