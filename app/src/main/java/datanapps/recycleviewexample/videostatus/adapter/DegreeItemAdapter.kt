package datanapps.recycleviewexample.videostatus.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.google.android.exoplayer2.ui.PlayerView
import datanapps.recycleviewexample.R


/*
* Created by Dev_Network_PC on 22/8/2021
*/

class DegreeItemAdapter (private val itemClickListener: OnDegreeItemClickListener)
    : ListAdapter<DegreeItem, DegreeVH>(DIFF_UTIL) {

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<DegreeItem>() {
            override fun areItemsTheSame(oldItem: DegreeItem, newItem: DegreeItem): Boolean {
                return oldItem.sameAs(newItem)
            }

            override fun areContentsTheSame(oldItem: DegreeItem, newItem: DegreeItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DegreeVH {
        val creator = DegreeVH.CREATORS[viewType]
        return creator?.invoke(parent, itemClickListener) ?: throw IllegalArgumentException("Invalid view type: $viewType")
    }

    override fun onBindViewHolder(holder: DegreeVH, position: Int) {
        getItem(position)?.bind(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    override fun onViewDetachedFromWindow(holder: DegreeVH) {
        super.onViewDetachedFromWindow(holder)

        if(holder is DegreeVideoVH){
            holder.itemView.findViewById<PlayerView>(R.id.exo_player_view).player?.pause()
        }
    }

    override fun onViewAttachedToWindow(holder: DegreeVH) {
        super.onViewAttachedToWindow(holder)
        if(holder is DegreeVideoVH){
            holder.itemView.findViewById<PlayerView>(R.id.exo_player_view).player?.play()
        }
    }
}