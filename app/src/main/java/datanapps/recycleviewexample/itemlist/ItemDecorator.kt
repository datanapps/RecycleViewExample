package datanapps.recycleviewexample.itemlist

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/*
* Created by Dev_Network_PC on 18/8/2021
*/

class ItemDecorator constructor(private val mSpace:Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view);
        if (position != 0)
            outRect.top = mSpace;
    }
}