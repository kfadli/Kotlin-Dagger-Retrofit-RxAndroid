package com.kfadli.pminister.activity.detail.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.R.string
import com.kfadli.pminister.response.AdvertsItem
import com.kfadli.pminister.util.QualityEnum
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.formatReview
import com.kfadli.pminister.util.toString
import kotlinx.android.synthetic.main.advert.view.comment_txt
import kotlinx.android.synthetic.main.advert.view.price_txt
import kotlinx.android.synthetic.main.advert.view.quality_product_txt
import kotlinx.android.synthetic.main.advert.view.sells_review_txt
import kotlinx.android.synthetic.main.advert.view.username_txt
import kotlin.math.roundToInt

class RecyclerAdvertsAdapter(

    private val adverts: List<AdvertsItem?>,
    private val context: Context) : RecyclerView.Adapter<RecyclerAdvertsAdapter.AdvertHolder>() {

  private val TAG: String = "RecyclerAdvertsAdapter"

  override fun getItemCount(): Int {
    return adverts.size
  }

  override fun onBindViewHolder(holder: AdvertHolder, position: Int) {
    holder.bind(adverts[position], context)
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdvertHolder {
    return AdvertHolder(
        LayoutInflater.from(parent?.context).inflate(R.layout.advert, parent, false))
  }

  class AdvertHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(advert: AdvertsItem?, context: Context) {


      itemView.price_txt.text = currencyFormat().format(advert?.salePrice!!.toDouble())
      itemView.username_txt.text = advert.seller?.login ?: ""
      itemView.quality_product_txt.text = QualityEnum.valueOf(advert.quality!!).toString(context)
      itemView.comment_txt.text = advert.sellerComment

      if (advert.seller?.averageScore == null) {
        itemView.sells_review_txt.text = context.getString(string.new_seller)
      } else {
        itemView.sells_review_txt.text = context.getString(R.string.average_seller,
            formatReview(advert.seller.averageScore), advert.seller.saleCount)
      }
    }

  }

}


