package datanapps.example.utils

import android.app.ActionBar
import android.content.res.Resources
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.*

/*
* Created by Dev_Network_PC on 18/8/2021
*/

fun ImageView.loadImage(url:String?) {
    url?.let {

        Glide
            .with(this.context)
            .load(it)
            .dontAnimate()
            .into(this);
    }

}


