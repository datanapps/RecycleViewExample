package datanapps.example.utils

import android.app.ActionBar
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import java.util.*

/*
* Created by Dev_Network_PC on 18/8/2021
*/

fun getUniqueId() = System.currentTimeMillis().toInt()

fun getRandomInt(max:Int = 5) = Random().nextInt(max-1)

fun getRandomColor(): Int {
    val rnd = Random()
    return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
}

fun getScreenHeight85() =  getScreenHeight()*0.85.toInt()

fun getScreenHeight() =  Resources.getSystem().displayMetrics.heightPixels


fun getScreenWidth() =  Resources.getSystem().displayMetrics.widthPixels