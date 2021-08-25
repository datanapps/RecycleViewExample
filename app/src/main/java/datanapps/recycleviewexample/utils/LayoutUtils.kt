package datanapps.example.utils

import android.graphics.Bitmap
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import datanapps.recycleviewexample.R
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable


/*
* Created by Dev_Network_PC on 18/8/2021
*/

fun ConstraintLayout.setColorFromBitmap(drawable: Drawable) {
    if(drawable is BitmapDrawable) {
        val bitmap = drawable.bitmap
        Palette.Builder(bitmap).generate {
            it?.let { palette ->
                val dominantColor =
                    palette.getDominantColor(ContextCompat.getColor(context, R.color.white))
                setBackgroundColor(dominantColor)

            }
        }
    }
}


