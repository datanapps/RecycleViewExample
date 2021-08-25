package datanapps.recycleviewexample.videostatus.adapter

import datanapps.recycleviewexample.videostatus.models.DegreeImage
import datanapps.recycleviewexample.videostatus.models.DegreeText
import datanapps.recycleviewexample.videostatus.models.DegreeVideo

/*
* Created by Dev_Network_PC on 22/8/2021
*/

interface OnVideoStateListener {
    fun onVideoState(data: VIDEO_STATE)
}

enum class VIDEO_STATE{
    PLAY, PAUSE, RELEASE

}