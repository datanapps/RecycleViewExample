package datanapps.recycleviewexample.videostatus.models

/*
* Created by Dev_Network_PC on 22/8/2021
*/


open class Degree (
    open val id:Int)

/**
 * [DegreeText]
 */
data class DegreeText(
    override val id: Int,
    val quote: String?
):Degree(id)

/**
 * [DegreeImage]
 */
data class DegreeImage(
    override val id: Int,
    val imageUrl: String?,
    val imageDescription: String?
):Degree(id)


/**
 * [DegreeVideo]
 */
data class DegreeVideo(
    override val id: Int,
    val videoSourceUrl: String?,
    val videoDescription: String?
):Degree(id)

