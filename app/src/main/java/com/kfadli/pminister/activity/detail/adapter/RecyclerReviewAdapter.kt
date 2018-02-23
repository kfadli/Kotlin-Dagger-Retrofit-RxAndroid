package com.kfadli.pminister.activity.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.detail.adapter.RecyclerReviewAdapter.ReviewHolder
import com.kfadli.pminister.response.ReviewsItem
import kotlinx.android.synthetic.main.review.view.date_txt
import kotlinx.android.synthetic.main.review.view.description
import kotlinx.android.synthetic.main.review.view.score
import kotlinx.android.synthetic.main.review.view.title_txt
import kotlinx.android.synthetic.main.review.view.username_txt
import java.util.Date

class RecyclerReviewAdapter(

    private val reviews: List<ReviewsItem?>) : RecyclerView.Adapter<ReviewHolder>() {

  private val TAG: String = "RecyclerReviewAdapter"

  override fun getItemCount(): Int {
    return reviews.size
  }

  override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
    holder.bind(reviews[position])
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ReviewHolder {
    return ReviewHolder(
        LayoutInflater.from(parent?.context).inflate(R.layout.review, parent, false))
  }

  class ReviewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(review: ReviewsItem?) {
      itemView.title_txt.text = review?.title ?: ""
      itemView.username_txt.text = review!!.author?.login ?: ""
      itemView.score.rating = review.note?.toFloat() ?: 0.0f
      itemView.description.text = review.description
      itemView.date_txt.text = Date(review.date!!).toString()
    }

  }

}


