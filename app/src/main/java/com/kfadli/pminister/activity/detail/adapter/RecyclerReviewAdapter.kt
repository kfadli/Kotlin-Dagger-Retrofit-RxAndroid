package com.kfadli.pminister.activity.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.detail.adapter.RecyclerReviewAdapter.ReviewHolder
import com.kfadli.pminister.response.ReviewsItem
import kotlinx.android.synthetic.main.review.view.*
import java.text.SimpleDateFormat
import java.util.*

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
        private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")

        fun bind(review: ReviewsItem?) {
            itemView.title_txt.text = review?.title ?: ""
            itemView.sells_review_txt.text = review!!.author?.login ?: ""
            itemView.score.rating = review.note?.toFloat() ?: 0.0f
            itemView.description.text = review.description
            itemView.date_txt.text = sdf.format(Date(review.date!!))
        }

    }

}


