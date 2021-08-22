package datanapps.recycleviewexample.itemlist.adapter

import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter


/*
* Created by Dev_Network_PC on 17/8/2021
*/

class ItemAdapter (val onItemRowClickListener: OnItemRowClickListener)
    : ListAdapter<Item, ItemVH>(ItemDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        return ItemVH.create(parent, onItemRowClickListener)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.bind(getItem(position))
    }
    }

