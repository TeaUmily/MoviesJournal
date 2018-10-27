package hr.ferit.tumiljanovic.moviesjournal.ui.movie_list

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.BaseFragment
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerAdapterImpl
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.RecyclerWrapper
import hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_backdrop.BackdropHolderData
import hr.ferit.tumiljanovic.moviesjournal.model.Genres
import hr.ferit.tumiljanovic.moviesjournal.model.Movie


class MovieListFragment : BaseFragment(), MovieListContract.View {

    @BindView(R.id.recyclerView_movie_list)
    lateinit var recycler: RecyclerView

    private val presenter : MovieListContract.Presenter? = null

    companion object {
        fun newInstance(): MovieListFragment {
            val fragment = MovieListFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.itemAnimator = DefaultItemAnimator()

       var g1: Genres = Genres("g!", "name")
        var geners: List<Genres> = listOf(g1)
        var data: BackdropHolderData = BackdropHolderData("lalalala")
        var rw1: RecyclerWrapper = RecyclerWrapper(data, RecyclerWrapper.TYPE_BACKDROP)
        var listdata: List<RecyclerWrapper> = listOf(rw1, rw1, rw1, rw1)


        var adapter: RecyclerAdapterImpl = RecyclerAdapterImpl(arrayListOf(), requireContext())

        adapter.addItems(listdata)
        recycler.adapter = adapter


    }


}