package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list

import android.os.Bundle
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.BaseFragment
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapterImpl
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import hr.ferit.tumiljanovic.moviesjournal.utils.Constants
import hr.ferit.tumiljanovic.moviesjournal.utils.divider_item_decorator.BaseDividerItemDecorator
import hr.ferit.tumiljanovic.moviesjournal.utils.divider_item_decorator.VerticalItemDivider

import javax.inject.Inject


class MovieListFragment : BaseFragment(), MovieListContract.View{

    @BindView(R.id.recyclerView_movie_list)
    lateinit var moviesRecyclerView: RecyclerView

    @Inject
    lateinit var presenter: MovieListContract.Presenter
    @Inject
    lateinit var adapter: RecyclerAdapterImpl

    companion object {
        fun newInstance(position: Int): MovieListFragment {
            var bundle: Bundle = Bundle()
            bundle.putInt(Constants.POSITION, position)
            val fragment = MovieListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        moviesRecyclerView.layoutManager = GridLayoutManager(context, 2)
        moviesRecyclerView.itemAnimator = DefaultItemAnimator()
        moviesRecyclerView.addItemDecoration(VerticalItemDivider())
        moviesRecyclerView.adapter = adapter

        getMovies()
    }

    override fun onSaveInstanceState(outState: Bundle) {

        val scrollY = moviesRecyclerView.computeVerticalScrollOffset()

        outState?.putInt("scrollY", scrollY)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        val scrollY = savedInstanceState?.getInt("scrollY") ?: 0

        moviesRecyclerView.scrollTo(0,scrollY)
        super.onViewStateRestored(savedInstanceState)
    }

    private fun getMovies() {
        var position: Int = this.arguments!!.getInt(Constants.POSITION)
        presenter.getMovies(position)
    }

    override fun showMovies(dataList: MutableList<RecyclerWrapper>) {
        adapter.addItems(dataList)
    }





}