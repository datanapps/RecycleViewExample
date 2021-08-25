package datanapps.recycleviewexample.videostatus

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import datanapps.example.utils.getCurrentPosition
import datanapps.example.utils.getRandomColor
import datanapps.example.utils.height85
import datanapps.recycleviewexample.R
import datanapps.recycleviewexample.databinding.ItemHorizontalDegreeBinding
import datanapps.recycleviewexample.videostatus.adapter.*
import datanapps.recycleviewexample.videostatus.models.DegreeVideo


/*
* Created by Dev_Network_PC on 17/8/2021
*/

class HorizontalDegreeAdapter(private val onItemRowClickListener: OnDegreeItemClickListener) :
    ListAdapter<HorizontalDegree, HorizontalDegreeVH>(DIFF_UTIL) {

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<HorizontalDegree>() {
            override fun areItemsTheSame(
                oldItem: HorizontalDegree,
                newItem: HorizontalDegree
            ): Boolean {
                return oldItem.degreeList == newItem.degreeList
            }

            override fun areContentsTheSame(
                oldItem: HorizontalDegree,
                newItem: HorizontalDegree
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalDegreeVH {
        return HorizontalDegreeVH.create(parent, onItemRowClickListener)
    }

    override fun onBindViewHolder(holder: HorizontalDegreeVH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewDetachedFromWindow(holder: HorizontalDegreeVH) {
        holder.pauseVideo()

    }

    override fun onViewAttachedToWindow(holder: HorizontalDegreeVH) {
        holder.resumeVideo()
    }

}

data class HorizontalDegree(
    val degreeList: MutableList<DegreeItem>
)

class HorizontalDegreeVH private constructor(
    itemView: View,
    onItemRowClickListener: OnDegreeItemClickListener
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun create(
            viewGroup: ViewGroup,
            onItemRowClickListener: OnDegreeItemClickListener
        ): HorizontalDegreeVH {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_horizontal_degree, viewGroup, false)

            //view.layoutParams = view.height85()
            //view.setBackgroundColor(getRandomColor())
            return HorizontalDegreeVH(view, onItemRowClickListener)
        }
    }

    private val binding = ItemHorizontalDegreeBinding.bind(itemView)
    private val degreeItemAdapter = DegreeItemAdapter(onItemRowClickListener)
    private var pausePosition = 0
    init {
        binding.run {
            rvHorizontalDegree.adapter = degreeItemAdapter
                    val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(rvHorizontalDegree)
        }
    }

    fun bind(item: HorizontalDegree) {
        binding.rvHorizontalDegree.setItemViewCacheSize(item.degreeList.size)
        degreeItemAdapter.submitList(item.degreeList)

    }

    fun pauseVideo(){

        val currentPosition = binding.rvHorizontalDegree.getCurrentPosition()

        Log.d("asd", "Current position : $currentPosition")

        Log.d("asd", "Current position : $currentPosition")
        val viewHolder = binding.rvHorizontalDegree.findViewHolderForAdapterPosition(currentPosition)
        if(viewHolder is DegreeVideoVH) {
            pausePosition = currentPosition
            degreeItemAdapter.onViewDetachedFromWindow(viewHolder)
        }
    }

    fun resumeVideo(){
            val viewHolder = binding.rvHorizontalDegree.findViewHolderForAdapterPosition(pausePosition)
            if(viewHolder is DegreeVideoVH) {
                degreeItemAdapter.onViewAttachedToWindow(viewHolder)
            }
    }

}

