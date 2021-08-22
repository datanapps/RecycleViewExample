package datanapps.example.utils

import android.app.ActionBar
import android.content.res.Resources
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import java.util.*

/*
* Created by Dev_Network_PC on 18/8/2021
*/

fun View.height85(): ViewGroup.LayoutParams {
    val height: Int = Resources.getSystem().displayMetrics.heightPixels
    val params = this.layoutParams
    params.height = (height * 0.85).toInt()
Log.d("asd", "height : ${params.height}")
    return params
}


