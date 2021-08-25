package datanapps.recycleviewexample.utils

import datanapps.example.utils.getRandomInt
import datanapps.example.utils.getUniqueId
import datanapps.recycleviewexample.videostatus.adapter.DegreeImageItem
import datanapps.recycleviewexample.videostatus.adapter.DegreeTextItem
import datanapps.recycleviewexample.videostatus.adapter.DegreeVideoItem
import datanapps.recycleviewexample.videostatus.models.DegreeImage
import datanapps.recycleviewexample.videostatus.models.DegreeText
import datanapps.recycleviewexample.videostatus.models.DegreeVideo

/*
* Created by Dev_Network_PC on 25/8/2021
*/

val DEGREE_QUOTE = listOf(
    "The greatest glory in living lies not in never falling, but in rising every time we fall.",
    "The way to get started is to quit talking and begin doing",
    "https://datanapps.com/",
    "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.",
    "If life were predictable it would cease to be life, and be without flavor.",
    "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.",
    "https://datanapps.com/",
    "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
    "Life is what happens when you're busy making other plans.",
    "https://datanapps.com/",
    "Spread love everywhere you go. Let no one ever come to you without leaving happier.",
    "When you reach the end of your rope, tie a knot in it and hang on.",
    "https://blogs.datanapps.com"
)


val DEGREE_IMAGE =
    listOf(
        "https://blogs.datanapps.com/uploads/images/image_650x433_60cf3f7a4a8f8.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_60a9da1501a7b.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_609a7b40b04cc.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_6030c31cc0f6b.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_6027cde22785c.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_602395987d532.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_5fd7895bbb577.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_5f4bc6fe5b75d.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_5f0a9c702abf0.jpg",
        "https://blogs.datanapps.com/uploads/images/image_650x433_5f50b8889688a.jpg"
    )

/*
* get video resource from https://gist.github.com/jsturgis/3b19447b304616f18657
* */
val DEGREE_VIDEO =
    listOf(
        "https://datanapps.com/public/dnarestapi/media/videos/MyExerciseMobile.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"
    )


fun getDegreeQuoteText() = DEGREE_QUOTE.get(getRandomInt(DEGREE_QUOTE.size))

fun getDegreeImageUrl() = DEGREE_IMAGE.get(getRandomInt(DEGREE_IMAGE.size))

fun getDegreeVideoSource() = DEGREE_IMAGE.get(getRandomInt(DEGREE_VIDEO.size))


fun getDegreeQuoteItem() : DegreeTextItem = DegreeTextItem(DegreeText(getUniqueId(), getDegreeQuoteText()))
fun getDegreeImageItem() : DegreeImageItem = DegreeImageItem(DegreeImage(getUniqueId(), getDegreeImageUrl(), ""))
fun getDegreeVideoItem() : DegreeVideoItem = DegreeVideoItem(DegreeVideo(getUniqueId(), getDegreeVideoSource(), ""))
