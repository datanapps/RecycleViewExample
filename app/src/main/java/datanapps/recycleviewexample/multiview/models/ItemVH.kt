package datanapps.recycleviewexample.multiview.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import datanapps.example.utils.getRandomColor
import datanapps.example.utils.loadImage
import datanapps.recycleviewexample.R
import datanapps.recycleviewexample.databinding.ItemImageBinding
import datanapps.recycleviewexample.databinding.ItemImageDetailBinding
import datanapps.recycleviewexample.databinding.ItemLabelBinding
import datanapps.recycleviewexample.multiview.adapter.OnMultiviewItemClickListener

/*
* Created by Dev_Network_PC on 22/8/2021
*/

abstract class ItemVH (itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        /**
         * Map a `viewType` to a function that can create [ItemVH]
         */
        val CREATORS: Map<Int, (ViewGroup, OnMultiviewItemClickListener) -> ItemVH> = mapOf(
            ItemLabelVH.LAYOUT_ID to ItemLabelVH.Companion::create,
            ItemDividerVH.LAYOUT_ID to ItemDividerVH.Companion::create,
            ItemImageVH.LAYOUT_ID to ItemImageVH.Companion::create,
            ItemImageDetailVH.LAYOUT_ID to ItemImageDetailVH.Companion::create,
        )
    }

    open fun displayLabel(item: ItemLabel) {}
    open fun displayDivider(item: BaseItems) {}
    open fun displayImage(item: ItemImage) {}
    open fun displayImageDetail(item: ItemImageDetail) {}
}

/**
 * ViewHolder corresponds to [ItemLabel]
 */
class ItemLabelVH(view: View) : ItemVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_label

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnMultiviewItemClickListener): ItemVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return ItemLabelVH(view)
        }
    }

    private val binding = ItemLabelBinding.bind(view)

    override fun displayLabel(item: ItemLabel) {
        binding.tvLabel.text = item.title
        binding.tvLabel.setTextColor(getRandomColor())
    }
}

class ItemDividerVH(view: View) : ItemVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_divider

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnMultiviewItemClickListener): ItemVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return ItemDividerVH(view)
        }
    }
}


/**
 * ViewHolder corresponds to [ItemIMage]
 */
class ItemImageVH(view: View) : ItemVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_image

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnMultiviewItemClickListener): ItemVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return ItemImageVH(view)
        }
    }

    private val binding = ItemImageBinding.bind(view)

    override fun displayImage(item: ItemImage) {
        super.displayImage(item)

        binding.ivImage.loadImage(item.imageUrl)
    }
}


/**
 * ViewHolder corresponds to [ItemIMage]
 */
class ItemImageDetailVH(view: View) : ItemVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_image_detail

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnMultiviewItemClickListener): ItemVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return ItemImageDetailVH(view)
        }
    }

    private val binding = ItemImageDetailBinding.bind(view)

    override fun displayImageDetail(item: ItemImageDetail) {
        super.displayImageDetail(item)

        binding.ivImage.loadImage(item.imageUrl)
        binding.tvImageDescription.text = item.imageDescription
    }
}
