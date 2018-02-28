package com.kfadli.pminister.activity.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.main.adapter.RecyclerProductsAdapter.ProductHolder
import com.kfadli.pminister.enums.FormatEnum
import com.kfadli.pminister.response.ProductsItem
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.loadUrl
import kotlinx.android.synthetic.main.product.view.new_price_txt
import kotlinx.android.synthetic.main.product.view.picture_img
import kotlinx.android.synthetic.main.product.view.reviews_txt
import kotlinx.android.synthetic.main.product.view.score
import kotlinx.android.synthetic.main.product.view.title_txt
import kotlinx.android.synthetic.main.product.view.used_price_txt

class RecyclerProductsAdapter(
    private val onClickListener: OnClickListener,
    private val products: List<ProductsItem?>?) : RecyclerView.Adapter<ProductHolder>(), Filterable {

  private val TAG: String = "RecyclerProductsAdapter"

  private val productsFiltered: ArrayList<ProductsItem?> = ArrayList()

  override fun getItemCount(): Int {
    return productsFiltered.size
  }

  override fun onBindViewHolder(holder: ProductHolder, position: Int) {
    holder.bind(productsFiltered[position]!!)
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
    return ProductHolder(parent?.context!!, onClickListener,
        LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false))
  }

  override fun getFilter(): Filter {

    return object : Filter() {

      private val filtered: ArrayList<ProductsItem?> = ArrayList()

      override fun performFiltering(constraint: CharSequence?): FilterResults {

        filtered.clear()

        if (constraint != null && constraint.isNotEmpty()) {
          val query = constraint.toString()

          products!!.forEach { t: ProductsItem? ->
            if (t!!.headline!!.contains(query, true)) {
              filtered.add(t)
            }
          }
        } else {
          filtered.addAll(products!!)
        }

        return FilterResults().apply {
          values = filtered
          count = filtered.size
        }
      }

      override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        productsFiltered.clear()
        if (results != null) {
          productsFiltered.addAll(results.values as MutableList<ProductsItem>)
        }
        notifyDataSetChanged()
      }
    }
  }


  class ProductHolder(val context: Context, val listener: OnClickListener,
      itemView: View?) : RecyclerView.ViewHolder(
      itemView) {

    fun bind(product: ProductsItem) {

      var items = product.images!![0]!!.imagesUrls!!.entry!!
          .filter { entryItem -> entryItem!!.size == FormatEnum.MEDIUM.name }

      itemView.title_txt.text = product.headline
      itemView.new_price_txt.text = "${currencyFormat().format(
          product.newBestPrice)} ${context?.getString(R.string.new_product)}"
      itemView.used_price_txt.text = """${currencyFormat().format(
          product.bestPrice)} ${context?.getString(R.string.used_product)}"""
      itemView.picture_img.loadUrl(items[0]!!.url!!)
      itemView.reviews_txt.text = "${product.nbReviews.toString()} ${context?.getString(
          R.string.reviews)}"
      itemView.score.rating = product.reviewsAverageNote!!.toFloat()

      itemView.setOnClickListener(listener)
    }

  }

}


