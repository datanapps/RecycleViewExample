package datanapps.recycleviewexample.itemlist.adapter

import androidx.recyclerview.widget.DiffUtil
import datanapps.recycleviewexample.itemlist.models.ItemData

/*
* Created by Dev_Network_PC on 17/8/2021
*/

class ItemDiffUtil: DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(
        oldItem: Item,
        newItem: Item
    ): Boolean {
        return oldItem.itemData == newItem.itemData
    }

    override fun areContentsTheSame(
        oldItem: Item,
        newItem: Item
    ): Boolean {
        return oldItem == newItem
    }
}

data class Item(
    val itemData: ItemData
)
