package datanapps.recycleviewexample.multiview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import datanapps.recycleviewexample.multiview.models.BaseItems
import datanapps.recycleviewexample.multiview.models.ItemVH
import datanapps.recycleviewexample.multiview.models.ItemLabel
import datanapps.recycleviewexample.multiview.adapter.OnMultiviewItemClickListener

/*
* Created by Dev_Network_PC on 22/8/2021
*/class MultiviewItemAdapter (private val itemClickListener: OnMultiviewItemClickListener)
    : ListAdapter<BaseItems, ItemVH>(DIFF_UTIL) {

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<BaseItems>() {
            override fun areItemsTheSame(oldItem: BaseItems, newItem: BaseItems): Boolean {
                return oldItem.sameAs(newItem)
            }

            override fun areContentsTheSame(oldItem: BaseItems, newItem: BaseItems): Boolean {
                return oldItem == newItem
            }
        }
    }

   /* private val menuItemClickListener = object : OnMultiviewItemClickListener {
        override fun onItemClick(data: Any) {
            when(data) {
                is ItemLabel -> itemClickListener.onItemClick(data)
            }
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val creator = ItemVH.CREATORS[viewType]
        return creator?.invoke(parent, itemClickListener) ?: throw IllegalArgumentException("Invalid view type: $viewType")
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        getItem(position)?.bind(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}