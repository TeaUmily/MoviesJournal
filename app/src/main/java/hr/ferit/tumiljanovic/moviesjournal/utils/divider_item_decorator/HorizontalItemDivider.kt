package hr.ferit.tumiljanovic.moviesjournal.utils.divider_item_decorator

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class HorizontalItemDivider : BaseDividerItemDecorator() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) != parent.adapter!!.itemCount) {
            outRect.left = horizontalSpaceWidth
            outRect.right = horizontalSpaceWidth
        }
    }
}