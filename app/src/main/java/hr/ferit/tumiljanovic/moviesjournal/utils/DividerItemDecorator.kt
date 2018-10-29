package hr.ferit.tumiljanovic.moviesjournal.utils


import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import hr.ferit.tumiljanovic.moviesjournal.App
import hr.ferit.tumiljanovic.moviesjournal.R

class DividerItemDecorator : RecyclerView.ItemDecoration() {


    private var verticalSpaceHeight: Int = 0

    init {
        this.verticalSpaceHeight = App.instance.baseContext.resources.getDimension(R.dimen.divider_space_height).toInt()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) != parent.adapter!!.itemCount) {
            outRect.bottom = verticalSpaceHeight
        }
    }
}