package com.kfadli.pminister.activity.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.response.AdvertsItem

class RecyclerAdvertsAdapter(

        private val adverts: List<AdvertsItem?>) : RecyclerView.Adapter<RecyclerAdvertsAdapter.AdvertHolder>() {

    private val TAG: String = "RecyclerAdvertsAdapter"

    override fun getItemCount(): Int {
        return adverts.size
    }

    override fun onBindViewHolder(holder: AdvertHolder, position: Int) {
        holder.bind(adverts[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdvertHolder {
        return AdvertHolder(
                LayoutInflater.from(parent?.context).inflate(R.layout.review, parent, false))
    }

    class AdvertHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(review: AdvertsItem?) {

            /*
            itemView.title_txt.text = review?.title ?: ""
            itemView.username_txt.text = review!!.author?.login ?: ""
            itemView.score.rating = review.note?.toFloat() ?: 0.0f
            itemView.description.text = review.description
            itemView.date_txt.text = Date(review.date!!).toString()
            */
        }

    }

}


