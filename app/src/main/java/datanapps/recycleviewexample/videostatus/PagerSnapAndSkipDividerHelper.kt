package datanapps.recycleviewexample.videostatus

import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING
import datanapps.example.utils.getScreenHeight85

/*
* Created by Dev_Network_PC on 24/8/2021
*/class PagerSnapAndSkipDividerHelper : PagerSnapHelper() {

    private var dx = 0

    override fun attachToRecyclerView(recyclerView: RecyclerView?) {
        super.attachToRecyclerView(recyclerView)
        recyclerView?.addOnScrollListener(onScrollListener)
    }

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int = getNextNonDividerPosition(
        super.findTargetSnapPosition(layoutManager, velocityX, velocityY)
    )

    private fun getNextNonDividerPosition(position: Int) = getScreenHeight85()


    private val onScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            this@PagerSnapAndSkipDividerHelper.dx = dx
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            if (listOf(SCROLL_STATE_IDLE, SCROLL_STATE_SETTLING).contains(newState)) {
                val viewToSnapTo = findSnapView(recyclerView.layoutManager) ?: return
                val position = recyclerView.layoutManager?.getPosition(viewToSnapTo) ?: return
                val nonDividerPosition = getNextNonDividerPosition(position)
                if (position != nonDividerPosition) {
                    recyclerView.smoothScrollToPosition(nonDividerPosition)
                }
            }
        }
    }
}