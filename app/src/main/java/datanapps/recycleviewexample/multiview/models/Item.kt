package datanapps.recycleviewexample.multiview.models

/*
* Created by Dev_Network_PC on 22/8/2021
*/


open class BaseData (
    open val id:Int)

/**
 * [LabelData]
 */
data class LabelData(
    override val id: Int,
    val label: String?
):BaseData(id)

/**
 * [ImageData]
 */
data class ImageData(
    override val id: Int,
    val imageUrl: String?,
    val imageDescription: String?
):BaseData(id)


/**
 * [UserData]
 */
data class UserData(
    override val id: Int,
    val name: String?,
    val email: String?,
    val image: String?
):BaseData(id)

