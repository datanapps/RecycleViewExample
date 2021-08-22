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
 * Component's Image
 */
data class ItemImage(val imageUrl: String?) : BaseItems() {
    override val type = ItemImageVH.LAYOUT_ID

    override fun bind(viewHolder: ItemVH) {
        viewHolder.displayImage(this)
    }

    override fun sameAs(item: BaseItems): Boolean = (item is ItemImage)
}

/**
 * Component's Image and detail
 */
data class ItemImageDetail(val imageUrl: String?, val imageDescription: String?) : BaseItems() {
    override val type = ItemImageDetailVH.LAYOUT_ID

    override fun bind(viewHolder: ItemVH) {
        viewHolder.displayImageDetail(this)
    }

    override fun sameAs(item: BaseItems): Boolean = (item is ItemImageDetail)
}
