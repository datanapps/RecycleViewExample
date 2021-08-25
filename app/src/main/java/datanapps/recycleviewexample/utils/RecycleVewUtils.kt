package datanapps.example.utils

import android.app.ActionBar
import android.content.res.Resources
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

/*
* Created by Dev_Network_PC on 18/8/2021
*/

fun RecyclerView?.getCurrentPosition() : Int {
    return (this?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
}


fun RecyclerView?.getCompleteVisiblePosition() : Int {
    return (this?.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
}