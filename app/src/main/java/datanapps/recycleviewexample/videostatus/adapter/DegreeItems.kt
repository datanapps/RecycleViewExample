package datanapps.recycleviewexample.videostatus.adapter

import datanapps.recycleviewexample.videostatus.models.DegreeImage
import datanapps.recycleviewexample.videostatus.models.DegreeText
import datanapps.recycleviewexample.videostatus.models.DegreeVideo

/*
* Created by Dev_Network_PC on 22/8/2021
*/


sealed class DegreeItem {

    abstract val type: Int

    abstract fun bind(viewHolder: DegreeVH)

    abstract fun sameAs(item: DegreeItem): Boolean
}

/**
 * TEXT component
 */
data class DegreeTextItem(val degreeText: DegreeText) : DegreeItem() {
    override val type = DegreeTextVH.LAYOUT_ID

    override fun bind(viewHolder: DegreeVH) {
        viewHolder.displayDegreeTextItem(this)
    }

    override fun sameAs(item: DegreeItem): Boolean = (item is DegreeTextItem)
}


/**
 * IMAGE component
 */
data class DegreeImageItem(val degreeImage: DegreeImage) : DegreeItem() {
    override val type = DegreeImageVH.LAYOUT_ID

    override fun bind(viewHolder: DegreeVH) {
        viewHolder.displayDegreeImageItem(this)
    }

    override fun sameAs(item: DegreeItem): Boolean = (item is DegreeImageItem)
}


/**
 *  VIDEO component
 */
data class DegreeVideoItem(val degreeVideo: DegreeVideo) : DegreeItem() {
    override val type = DegreeVideoVH.LAYOUT_ID

    override fun bind(viewHolder: DegreeVH) {
        viewHolder.displayDegreeVideoItem(this)
    }

    override fun sameAs(item: DegreeItem): Boolean = (item is DegreeVideoItem)
}

