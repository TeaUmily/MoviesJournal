package hr.ferit.tumiljanovic.moviesjournal.ui.home

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import hr.ferit.tumiljanovic.moviesjournal.ui.movie_list.MovieListFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    var size: Int = 0

    override fun getItem(position: Int) = MovieListFragment.newInstance()

    override fun getCount() = size

}