package datanapps.recycleviewexample.multiview.models

/*
* Created by Dev_Network_PC on 22/8/2021
*/


sealed class BaseItems {

    abstract val type: Int

    abstract fun bind(viewHolder: ItemVH)

    abstract fun sameAs(item: BaseItems): Boolean
}

/**
 * Component's label
 */
data class ItemLabel(val title: String?) : BaseItems() {
    override val type = ItemLabelVH.LAYOUT_ID

    override fun bind(viewHolder: ItemVH) {
        viewHolder.displayLabel(this)
    }

    override fun sameAs(item: BaseItems): Boolean = (item is ItemLabel)
}

/**
 * Component divider
 */
 class ItemDivider : BaseItems() {
    override val type = ItemDividerVH.LAYOUT_ID

    override fun bind(viewHolder: ItemVH) {}

    override fun sameAs(item: BaseItems): Boolean = true
}

/**
 * Component's label
 */
data class ItemImage(val imageUrl: String?) : BaseItems() {
    override val type = ItemImageVH.LAYOUT_ID

    override fun bind(viewHolder: ItemVH) {
        viewHolder.displayImage(this)
    }

    override fun sameAs(item: BaseItems): Boolean = (item is ItemLabel)
}
