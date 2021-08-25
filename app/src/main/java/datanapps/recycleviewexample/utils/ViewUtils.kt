package datanapps.example.utils

import android.content.res.Resources
import android.util.Log
import android.view.View
import android.view.ViewGroup

/*
* Created by Dev_Network_PC on 18/8/2021
*/

fun View.height85(): ViewGroup.LayoutParams {
    val height: Int = Resources.getSystem().displayMetrics.heightPixels
    val params = this.layoutParams
    params.height = (height * 0.85).toInt()
    return params
}


