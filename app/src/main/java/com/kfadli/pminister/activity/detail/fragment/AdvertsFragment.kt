package com.kfadli.pminister.activity.detail.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.detail.adapter.RecyclerAdvertsAdapter
import com.kfadli.pminister.response.AdvertsItem


class AdvertsFragment : Fragment() {

  lateinit var advertsList: List<AdvertsItem?>


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {

    // Creates the view controlled by the fragment
    val view = inflater.inflate(R.layout.fragment_reviews, container, false)


    val reviews_recycler = view.findViewById<RecyclerView>(R.id.reviews_recycler)

    //Setup recycler View
    reviews_recycler.addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    reviews_recycler.layoutManager = LinearLayoutManager(context)

    reviews_recycler.adapter = RecyclerAdvertsAdapter(advertsList, context!!)

    return view
  }

  companion object {

    fun newInstance(advertsList: List<AdvertsItem?>?): AdvertsFragment {

      // Create a new AdvertFragment and set the Bundle as the arguments
      val fragment = AdvertsFragment()

      //Drop first element (offer already display on header)
      fragment.advertsList = advertsList!!.drop(1)

      return fragment
    }
  }
}