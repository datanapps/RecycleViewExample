package datanapps.recycleviewexample.videostatus.adapter

import datanapps.recycleviewexample.videostatus.models.DegreeImage
import datanapps.recycleviewexample.videostatus.models.DegreeText
import datanapps.recycleviewexample.videostatus.models.DegreeVideo

/*
* Created by Dev_Network_PC on 22/8/2021
*/

interface OnDegreeItemClickListener {
    fun onItemTextClick(data: DegreeText)
    fun onItemImageClick(data: DegreeImage)
    fun onItemVideoClick(data: DegreeVideo)
}