package datanapps.recycleviewexample.videostatus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.PagerSnapHelper

import datanapps.example.utils.getCurrentPosition
import datanapps.example.utils.getRandomInt
import datanapps.recycleviewexample.databinding.ActivityMainBinding
import datanapps.recycleviewexample.utils.getDegreeImageItem
import datanapps.recycleviewexample.utils.getDegreeQuoteItem
import datanapps.recycleviewexample.utils.getDegreeVideoItem
import datanapps.recycleviewexample.videostatus.adapter.DegreeItem
import datanapps.recycleviewexample.videostatus.adapter.OnDegreeItemClickListener
import datanapps.recycleviewexample.videostatus.models.DegreeImage
import datanapps.recycleviewexample.videostatus.models.DegreeText
import datanapps.recycleviewexample.videostatus.models.DegreeVideo

class DegreeListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val concatAdapter =  ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        *
        * partially showing next item
        * */
        multiviewListItem()
    }

    /*
    * PLease enable layout size in DegreeVH.kt
    *  // view.layoutParams = view.height80()
    *
    * */
    private fun multiviewListItem() {
        binding.run {

            // set adapter in recycle view
            //recyclerView.addItemDecoration(ItemDecorator(-200))
            recyclerView.adapter = concatAdapter
            recyclerView.setItemViewCacheSize(5)
            val snapHelper = PagerSnapHelper()
            //val snapHelper = MultiSnapHelper(SnapGravity.START, 1, 20f)
            snapHelper.attachToRecyclerView(recyclerView)

            //snapHelper.(recyclerView.layoutManager, getScreenHeight(), 0)

            // create data set
            (1..5).forEach { index ->
                // create adapter for each row
                val horizontalDegreeAdapter = HorizontalDegreeAdapter(degreeItemClickListener)
                horizontalDegreeAdapter.submitList(mutableListOf(HorizontalDegree(getHorizontalRowItem(index))))
                // add adapter in concat

                concatAdapter.addAdapter(horizontalDegreeAdapter)
            }

        }
    }


    private fun getHorizontalRowItem(rowNumber:Int) : MutableList<DegreeItem> {
        val items = mutableListOf<DegreeItem>()
        (1..5).forEach {
            if(getRandomInt()%2==0)
            items.add(getDegreeImageItem())

            if(getRandomInt()%3==0)
            items.add(getDegreeQuoteItem())

            if(getRandomInt()%3==0)
            items.add(getDegreeVideoItem())

        }

        return items
    }

    val degreeItemClickListener = object : OnDegreeItemClickListener {
        override fun onItemTextClick(data: DegreeText) {
            Log.d("asd", "Item Clicked ${data}")
        }

        override fun onItemImageClick(data: DegreeImage) {
            Log.d("asd", "Item Clicked ${data}")
        }

        override fun onItemVideoClick(data: DegreeVideo) {
            Log.d("asd", "Item Clicked ${data}")
        }
    }

    override fun onPause() {
        super.onPause()
        pauseVideo()

    }

    override fun onResume() {
        super.onResume()
        resumeVideo()
    }
    var currentPosition=0


    fun pauseVideo(){
        currentPosition = binding.recyclerView.getCurrentPosition()
        Log.d("asd", "Current position : $currentPosition")
        Log.d("asd", "Current position : $currentPosition")
        val viewHolder = binding.recyclerView.findViewHolderForAdapterPosition(currentPosition)
        if(viewHolder is HorizontalDegreeVH) {
            concatAdapter.onViewDetachedFromWindow(viewHolder)
        }
    }

    fun resumeVideo(){
        val viewHolder = binding.recyclerView.findViewHolderForAdapterPosition(currentPosition)
        if(viewHolder is HorizontalDegreeVH) {
            concatAdapter.onViewAttachedToWindow(viewHolder)
        }
    }


}