package datanapps.recycleviewexample.videostatus.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.MimeTypes
import datanapps.example.utils.getRandomColor
import datanapps.example.utils.loadImage
import datanapps.example.utils.setColorFromBitmap
import datanapps.recycleviewexample.R
import datanapps.recycleviewexample.databinding.ItemDegreeImageBinding
import datanapps.recycleviewexample.databinding.ItemDegreeTextBinding
import datanapps.recycleviewexample.databinding.ItemDegreeVideoBinding

/*
* Created by Dev_Network_PC on 22/8/2021
*/

abstract class DegreeVH (itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        /**
         * Map a `viewType` to a function that can create [DegreeVH]
         */
        val CREATORS: Map<Int, (ViewGroup, OnDegreeItemClickListener) -> DegreeVH> = mapOf(
            DegreeTextVH.LAYOUT_ID to DegreeTextVH.Companion::create,
            DegreeImageVH.LAYOUT_ID to DegreeImageVH.Companion::create,
            DegreeVideoVH.LAYOUT_ID to DegreeVideoVH.Companion::create,
        )
    }

    open fun displayDegreeTextItem(item: DegreeTextItem) {}
    open fun displayDegreeImageItem(item: DegreeImageItem) {}
    open fun displayDegreeVideoItem(item: DegreeVideoItem) {}
}

/**
 * ViewHolder corresponds to [DegreeTextVH]
 */
class DegreeTextVH(view: View, val itemClickListener: OnDegreeItemClickListener) : DegreeVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_degree_text

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnDegreeItemClickListener): DegreeVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return DegreeTextVH(view, itemClickListener)
        }
    }

    private val binding = ItemDegreeTextBinding.bind(view)

    override fun displayDegreeTextItem(item: DegreeTextItem) {
        binding.tvLabel.text =  item.degreeText.quote
        binding.tvLabel.setTextColor(getRandomColor())
        binding.root.setOnClickListener { itemClickListener.onItemTextClick(item.degreeText) }
    }
}



/**
 * ViewHolder corresponds to [DegreeTextVH]
 */
class DegreeImageVH(view: View, val itemClickListener: OnDegreeItemClickListener) : DegreeVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_degree_image

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnDegreeItemClickListener): DegreeVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return DegreeImageVH(view, itemClickListener)
        }
    }

    private val binding = ItemDegreeImageBinding.bind(view)

    override fun displayDegreeImageItem(item: DegreeImageItem) {
        super.displayDegreeImageItem(item)
        binding.ivImageDegree.loadImage(item.degreeImage.imageUrl){
            it?.let {
                binding.root.setColorFromBitmap(it)
            }
        }
        item.degreeImage.imageDescription?.let {
            binding.tvImageDescriptionLabel.text = it
        }

        binding.root.setOnClickListener { itemClickListener.onItemImageClick(item.degreeImage) }
    }
}


/**
 * ViewHolder corresponds to [DegreeVideoVH]
 */
class DegreeVideoVH(view: View, val itemClickListener: OnDegreeItemClickListener) : DegreeVH(view) {

    companion object {
        const val LAYOUT_ID = R.layout.item_degree_video

        @Suppress("UNUSED_PARAMETER")
        fun create(parent: ViewGroup, itemClickListener: OnDegreeItemClickListener): DegreeVH {
            val view = LayoutInflater.from(parent.context).inflate(LAYOUT_ID, parent, false)
            return DegreeVideoVH(view, itemClickListener)
        }
    }

    private val binding = ItemDegreeVideoBinding.bind(view)

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0

    override fun displayDegreeVideoItem(item: DegreeVideoItem) {
        super.displayDegreeVideoItem(item)
        prepareExoplayerView(binding.exoPlayerView, item)
        binding.root.setOnClickListener { itemClickListener.onItemVideoClick(item.degreeVideo) }

    }


    private fun prepareExoplayerView(playerView:PlayerView, item: DegreeVideoItem){
       val player = SimpleExoPlayer.Builder(itemView.context)
            .build()
        playerView.setPlayer(player)
        player.setMediaItem(MediaItem.fromUri(item.degreeVideo.videoSourceUrl!!))

        // prepare media list
        player.playWhenReady = playWhenReady;
        player.seekTo(currentWindow, playbackPosition);
        //player.addListener(this);
        player.prepare();
    }

    private fun getMediaItem(videoSourceUrl:String?) : MediaItem {
        // add one media item
        // val mediaItem: MediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
        return MediaItem.Builder()
            .setUri(Uri.parse(videoSourceUrl))
            .setMimeType(MimeTypes.BASE_TYPE_VIDEO)
            //.setAdTagUri(Uri.parse(ADS_URL))
            .build()
    }
}