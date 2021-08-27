# RecycleViewExample

Recycle view for SIMPLE LIST, MULTIVIEW, STATUS(whatsapp, youtube and many more.) 

## LIST
<img src="https://github.com/datanapps/RecycleViewExample/blob/main/screens/simple_list_item.png" height="500" width="250"> 

### Follow Package name : datanapps.recycleviewexample.itemlist.ItemListActivity

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



## PARTIALLY VISIBLE NEXT ITEM
<img src="https://github.com/datanapps/RecycleViewExample/blob/main/screens/partially_visible.png" height="500" width="250"> 

### Follow Package name : datanapps.recycleviewexample.itemlist.ItemListActivity
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


## MULTIVIEW
<img src="https://github.com/datanapps/RecycleViewExample/blob/main/screens/multiview_1.png" height="500" width="250"> 

### Follow Package name : datanapps.recycleviewexample.multiview.MultiviewItemAdapter

           /*
               * Please enable layout size in ItemVH.kt
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

                       // set item in list
                       adapter.submitList(loadData())
                   }
               }

--------------------------------------------------


  [![See](https://datanapps.com/public/dnarestapi/buy/buy_coffee2.png)](https://www.paypal.me/datanappspaynow)

  ### License

Copyright [2021] [datanapps]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
   http://www.apache.org/licenses/LICENSE-2.0
