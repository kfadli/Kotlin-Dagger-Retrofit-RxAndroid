package com.kfadli.pminister.util

import com.kfadli.pminister.response.ImagesItem


fun filterUrlByFormat(
    imagesItem: List<ImagesItem?>?, format: String): ArrayList<String> {

  val urls = ArrayList<String>()

  imagesItem!!
      .forEach { item: ImagesItem? ->
        item?.imagesUrls!!.entry!!
            .filter { entryItem -> entryItem!!.size == format }
            .map { entryItem -> urls.add(entryItem!!.url!!) }
      }

  return urls
}
