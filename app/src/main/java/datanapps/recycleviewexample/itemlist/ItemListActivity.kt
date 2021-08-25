package datanapps.recycleviewexample.itemlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import datanapps.recycleviewexample.itemlist.models.ItemData
import datanapps.recycleviewexample.itemlist.adapter.ItemAdapter
import datanapps.recycleviewexample.itemlist.adapter.Item
import datanapps.recycleviewexample.itemlist.adapter.OnItemRowClickListener
import datanapps.recycleviewexample.databinding.ActivityMainBinding

class ItemListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*
        * For simple list
        * */
        //simpleItemList()


        /*
        *
        * partially showing next item
        * */
        partiallyShowingNextItem()
    }

    private fun simpleItemList(){
        // create adapter
        val adapter = ItemAdapter(object : OnItemRowClickListener {
            override fun onItemRowClick(itemData: ItemData) {
                Log.d("asd", "Item Clicked ${itemData.description}")
            }
        })
        binding.run {

            // set adapter in recycle view
            recyclerView.adapter = adapter

            // create data set
            val items = mutableListOf<Item>()
            (1..20).forEach {
                items.add(Item(ItemData(it, "description $it")))
            }
            // set item in list
            adapter.submitList(items)
        }
    }


    /*
    * PLease enable layout size in DegreeVH.kt
    *  // view.layoutParams = view.height80()
    *
    * */
    private fun partiallyShowingNextItem(){
        // create adapter
        val adapter = ItemAdapter(object : OnItemRowClickListener {
            override fun onItemRowClick(itemData: ItemData) {
                Log.d("asd", "Item Clicked ${itemData.description}")
            }
        })
        binding.run {

            // set adapter in recycle view
            recyclerView.addItemDecoration(ItemDecorator(-160))
            recyclerView.adapter = adapter

            val helper: SnapHelper = PagerSnapHelper()
            helper.attachToRecyclerView(binding.recyclerView)

            // create data set
            val items = mutableListOf<Item>()
            (1..20).forEach {
                items.add(Item(ItemData(it, "description $it")))
            }
            // set item in list
            adapter.submitList(items)
        }
    }
}