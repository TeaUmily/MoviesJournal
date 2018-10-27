package hr.ferit.tumiljanovic.moviesjournal.ui.home


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import hr.ferit.tumiljanovic.moviesjournal.R
import hr.ferit.tumiljanovic.moviesjournal.base.BaseActivity


class HomeActivity() : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.bottom_navigation)
    lateinit var bottomNavigation: BottomNavigationView

    @BindView(R.id.viewpager_home)
    lateinit var viewpager: ViewPager

    var prevMenuItem : MenuItem? = null

    var pagerAdapter: PagerAdapter = PagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ButterKnife.bind(this)

        viewpager.addOnPageChangeListener(this)
        pagerAdapter.size = 3
        viewpager.adapter = pagerAdapter


        bottomNavigation.setOnNavigationItemSelectedListener(this)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.upcomingMovies -> {
                viewpager.currentItem = 0
            }
            R.id.topRatedMovies -> {
                viewpager.currentItem = 1
            }
            R.id.popularMovies -> {

                viewpager.currentItem = 2
            }
        }
        return false
    }

    override fun onPageScrollStateChanged(p0: Int) {
       
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

    override fun onPageSelected(position: Int) {
        if (prevMenuItem != null) {
            prevMenuItem!!.isChecked = false
        } else {
            bottomNavigation.menu.getItem(0).isChecked = false
        }

        bottomNavigation.menu.getItem(position).isChecked = true
        prevMenuItem = bottomNavigation.menu.getItem(position)
    }

}
