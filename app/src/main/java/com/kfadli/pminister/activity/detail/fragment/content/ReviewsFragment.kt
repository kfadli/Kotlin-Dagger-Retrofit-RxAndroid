package com.kfadli.pminister.activity.detail.fragment.content

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.detail.adapter.RecyclerReviewAdapter
import com.kfadli.pminister.response.ReviewsItem

class ReviewsFragment : Fragment() {

  lateinit var reviews: List<ReviewsItem?>


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {

    // Creates the view controlled by the fragment
    val view = inflater.inflate(R.layout.fragment_reviews, container, false)


    val reviews_recycler = view.findViewById<RecyclerView>(R.id.reviews_recycler)

    reviews_recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    reviews_recycler.setHasFixedSize(true)
    reviews_recycler.layoutManager = LinearLayoutManager(context)

    reviews_recycler.adapter = RecyclerReviewAdapter(reviews)

    return view
  }

  companion object {

    fun newInstance(reviews: List<ReviewsItem?>?): ReviewsFragment {

      // Create a new ReviewsFragment and set the Bundle as the arguments
      val fragment = ReviewsFragment()
      fragment.reviews = reviews!!
      return fragment
    }
  }
}