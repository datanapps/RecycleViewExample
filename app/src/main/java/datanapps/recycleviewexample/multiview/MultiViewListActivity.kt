package datanapps.recycleviewexample.multiview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import datanapps.recycleviewexample.databinding.ActivityMainBinding
import datanapps.recycleviewexample.multiview.adapter.OnMultiviewItemClickListener
import datanapps.recycleviewexample.multiview.models.*

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
    private fun multiviewListItem() {
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


            // set item in list
            adapter.submitList(loadData())
        }
    }

    private fun loadData(): List<BaseItems> {
        val items = mutableListOf<BaseItems>()
        (1..20).forEach {
            when {
                (it % 5 == 0) -> {
                    items.add(
                        ItemImage(
                            ImageData(
                                it,
                                "https://blogs.datanapps.com/uploads/images/image_650x433_6027cde22785c.jpg",
                                ""
                            )
                        )
                    )
                }
                (it % 2 == 0) -> {
                    items.add(
                        ItemUser(
                            UserData(
                                it,
                                "John",
                                "john@gmail.com",
                                "https://blogs.datanapps.com/uploads/logo/logo_5eaed0862b41e.png"
                            )
                        )
                    )
                }
                else -> {
                    items.add(ItemLabel(LabelData(it, "Label : $it")))
                    items.add(ItemDivider())
                }
            }

        }
        return items
    }


}