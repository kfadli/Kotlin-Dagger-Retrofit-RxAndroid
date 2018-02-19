package com.kfadli.pminister.activity.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.main.adapter.RecyclerProductsAdapter.ProductHolder
import com.kfadli.pminister.response.ProductsItem
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.loadUrl

import kotlinx.android.synthetic.main.product.view.*
import java.text.NumberFormat

class RecyclerProductsAdapter(

    private val products: List<ProductsItem?>?) : RecyclerView.Adapter<ProductHolder>() {

  override fun getItemCount(): Int {
    return products?.size ?: 0
  }

  override fun onBindViewHolder(holder: ProductHolder, position: Int) {
    holder.bind(products!![position]!!)
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
    return ProductHolder(
        LayoutInflater.from(parent?.context).inflate(R.layout.product, parent, false))
  }

  class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), OnClickListener {


    override fun onClick(v: View?) {
    }

    fun bind(product: ProductsItem) {

      var items = product.images!![0]!!.imagesUrls!!.entry!!
          .filter { entryItem -> entryItem!!.size == "MEDIUM" }

      itemView.title_txt.text = product.headline
      itemView.new_price_txt.text = currencyFormat().format(product.newBestPrice)
      itemView.used_price_txt.text = currencyFormat().format(product.bestPrice)
      itemView.picture_img.loadUrl(items[0]!!.url!!)
    }

  }

}


