package com.kfadli.pminister.activity.detail.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter.FilterListener
import android.widget.TextView
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.detail.adapter.RecyclerAdvertsAdapter
import com.kfadli.pminister.enums.AdvertTypeEnum
import com.kfadli.pminister.response.AdvertsItem


class AdvertsFragment : Fragment() {

  lateinit var advertsList: List<AdvertsItem?>
  lateinit var adapter: RecyclerAdvertsAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {

    // Creates the view controlled by the fragment
    val view = inflater.inflate(R.layout.fragment_adverts, container, false)

    val adverts_recycler = view.findViewById<RecyclerView>(R.id.adverts_recycler)
    //Setup recycler View
    adverts_recycler.addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    adverts_recycler.layoutManager = LinearLayoutManager(context)

    adapter = RecyclerAdvertsAdapter(advertsList, context!!)
    adverts_recycler.adapter = adapter

    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val advertsAvailable = view.findViewById<TextView>(R.id.adverts_available)

    //Handle AdvertType Filter
    val disable_filter = view.findViewById<Button>(R.id.filter_disable_btn)
    val new_filter = view.findViewById<Button>(R.id.filter_new_btn)
    val used_filter = view.findViewById<Button>(R.id.filter_used_btn)

    val listener = FilterListener { count ->
      advertsAvailable.setText(getString(R.string.advert_available, count))
    }

    disable_filter.setOnClickListener { v -> adapter.filter.filter("", listener) }
    new_filter.setOnClickListener { v ->
      adapter.filter.filter(AdvertTypeEnum.NEW.name, listener)
    }
    used_filter.setOnClickListener { v ->
      adapter.filter.filter(AdvertTypeEnum.USED.name, listener)
    }

    adapter.filter.filter("", listener)

  }


  companion object {

    fun newInstance(advertsList: List<AdvertsItem?>?): AdvertsFragment {

      // Create a new AdvertFragment and set the Bundle as the arguments
      val fragment = AdvertsFragment()
      fragment.retainInstance = true

      //Drop first element (offer already display on header)
      fragment.advertsList = advertsList!!.drop(1)

      return fragment
    }
  }
}