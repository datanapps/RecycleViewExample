package datanapps.example.utils


import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/*
* Created by Dev_Network_PC on 18/8/2021
*/


fun ImageView.loadImage(url:String?) {
    url?.let {
        Glide
            .with(this.context)
            .load(it)
            .dontAnimate()
            .into(this)

    }

}
fun ImageView.loadImageBitmap(url:String?, onLoadImage: ((drawable: Drawable?) -> Unit)? = null) {
    url?.let {
        Glide
            .with(this.context)
            .load(it)
            .dontAnimate()
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onLoadImage?.invoke(resource)
                    return true
                }
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(this)

    }

}


