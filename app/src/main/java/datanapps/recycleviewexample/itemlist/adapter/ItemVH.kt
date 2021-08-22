package datanapps.recycleviewexample.itemlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import datanapps.example.utils.getRandomColor
import datanapps.example.utils.height85
import datanapps.recycleviewexample.R
import datanapps.recycleviewexample.databinding.ItemRowBinding


/*
* Created by Dev_Network_PC on 17/8/2021
*/

class ItemVH private constructor(
    itemView: View,
    private val onItemRowClickListener: OnItemRowClickListener
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun create(
            viewGroup: ViewGroup,
            onItemRowClickListener: OnItemRowClickListener
        ): ItemVH {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_row, viewGroup, false)

            view.layoutParams = view.height85()
            view.setBackgroundColor(getRandomColor())
            return ItemVH(view, onItemRowClickListener)
        }
    }



    private val binding = ItemRowBinding.bind(itemView)

    fun bind(item: Item) {
        binding.run {
            textview.text = item.itemData.description
        }

        binding.root.setOnClickListener{
            onItemRowClickListener.onItemRowClick(item.itemData)
        }

    }

}