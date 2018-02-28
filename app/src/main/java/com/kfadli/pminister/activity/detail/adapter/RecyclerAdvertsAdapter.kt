package com.kfadli.pminister.activity.detail.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.kfadli.pminister.R
import com.kfadli.pminister.enums.QualityEnum
import com.kfadli.pminister.response.AdvertsItem
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.formatSellsAndReviews
import com.kfadli.pminister.util.toString
import kotlinx.android.synthetic.main.advert.view.comment_txt
import kotlinx.android.synthetic.main.advert.view.price_txt
import kotlinx.android.synthetic.main.advert.view.quality_product_txt
import kotlinx.android.synthetic.main.advert.view.sells_review_txt
import kotlinx.android.synthetic.main.advert.view.username_txt

class RecyclerAdvertsAdapter(

    private val adverts: List<AdvertsItem?>,
    private val context: Context) : RecyclerView.Adapter<RecyclerAdvertsAdapter.AdvertHolder>(), Filterable {

  private val advertsFiltered: ArrayList<AdvertsItem?> = ArrayList()

  private val TAG: String = "RecyclerAdvertsAdapter"

  override fun getItemCount(): Int {
    return advertsFiltered.size
  }

  override fun onBindViewHolder(holder: AdvertHolder, position: Int) {
    holder.bind(advertsFiltered[position], context)
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdvertHolder {
    return AdvertHolder(
        LayoutInflater.from(parent?.context).inflate(R.layout.advert, parent, false))
  }

  override fun getFilter(): Filter {

    return object : Filter() {

      private val filtered: ArrayList<AdvertsItem?> = ArrayList()

      override fun performFiltering(constraint: CharSequence?): FilterResults {

        filtered.clear()

        if (constraint != null && constraint.isNotEmpty()) {
          val query = constraint.toString()

          adverts.forEach { t: AdvertsItem? ->
            if (t!!.type!!.contentEquals(query)) {
              filtered.add(t)
            }
          }
        } else {
          filtered.addAll(adverts)
        }

        return FilterResults().apply {
          values = filtered
          count = filtered.size
        }
      }

      override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        advertsFiltered.clear()
        if (results != null) {
          advertsFiltered.addAll(results.values as MutableList<AdvertsItem>)
        }
        notifyDataSetChanged()
      }
    }
  }

  class AdvertHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(advert: AdvertsItem?, context: Context) {

      itemView.price_txt.text = currencyFormat().format(advert?.salePrice!!.toDouble())
      itemView.username_txt.text = advert.seller?.login ?: ""
      itemView.comment_txt.text = advert.sellerComment

      itemView.quality_product_txt.text = QualityEnum.valueOf(advert.quality!!).toString(context)
      itemView.sells_review_txt.text = advert.seller!!.formatSellsAndReviews(context)

    }

  }

}


