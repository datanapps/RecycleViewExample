package datanapps.recycleviewexample.multiview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import datanapps.recycleviewexample.databinding.ActivityMainBinding
import datanapps.recycleviewexample.multiview.adapter.OnMultiviewItemClickListener
import datanapps.recycleviewexample.multiview.models.BaseItems
import datanapps.recycleviewexample.multiview.models.ItemDivider
import datanapps.recycleviewexample.multiview.models.ItemImage
import datanapps.recycleviewexample.multiview.models.ItemLabel

class MultiViewListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


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
    private fun multiviewListItem(){
        // create adapter
        val adapter = MultiviewItemAdapter(object : OnMultiviewItemClickListener {
            override fun onItemClick(data: Any) {
                Log.d("asd", "Item Clicked ${data}")
            }

            override fun onItemClickImage(data: Any) {

                Log.d("asd", "Image clicked ${data}")
            }
        })
        binding.run {

            // set adapter in recycle view

            recyclerView.adapter = adapter


            // create data set
            val items = mutableListOf<BaseItems>()
            (1..20).forEach {
                items.add(ItemLabel("Label : $it"))
                items.add(ItemDivider())

                if(it%5==0) {
                    items.add(ItemImage("https://blogs.datanapps.com/uploads/images/image_750x_6117e51dc82b2.jpg"))
                }
            }
            // set item in list
            adapter.submitList(items)
        }
    }


}