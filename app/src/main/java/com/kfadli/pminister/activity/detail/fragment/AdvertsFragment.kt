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
import com.kfadli.pminister.util.Constant


class AdvertsFragment : Fragment() {

  lateinit var advertsList: ArrayList<AdvertsItem?>
  lateinit var adapter: RecyclerAdvertsAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {

    //Creates the view controlled by the fragment
    val view = inflater.inflate(R.layout.fragment_adverts, container, false)

    val adverts_recycler = view.findViewById<RecyclerView>(R.id.adverts_recycler)
    //Setup recycler View
    adverts_recycler.addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    adverts_recycler.layoutManager = LinearLayoutManager(context)

    //Reload data from state
    if (savedInstanceState != null) {
      advertsList = savedInstanceState.getParcelableArrayList(Constant.ADVERTS_PARCELABLE)
    }

    adapter = RecyclerAdvertsAdapter(advertsList, context!!)
    adverts_recycler.adapter = adapter

    return view
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putParcelableArrayList(Constant.ADVERTS_PARCELABLE, advertsList)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val advertsAvailable = view.findViewById<TextView>(R.id.adverts_available)

    //Handle AdvertType Filter
    val disablefilter = view.findViewById<Button>(R.id.filter_disable_btn)
    val newfilter = view.findViewById<Button>(R.id.filter_new_btn)
    val usedfilter = view.findViewById<Button>(R.id.filter_used_btn)


    val listener = FilterListener { count ->
      advertsAvailable.text = getString(R.string.advert_available, count)
    }

    //Update Filter and buttons state (can be optimized...)
    disablefilter.setOnClickListener { v ->
      adapter.filter.filter("", listener)
      v.isEnabled = false
      newfilter.isEnabled = true
      usedfilter.isEnabled = true
    }

    newfilter.setOnClickListener { v ->
      adapter.filter.filter(AdvertTypeEnum.NEW.name, listener)
      v.isEnabled = false
      usedfilter.isEnabled = true
      disablefilter.isEnabled = true
    }
    usedfilter.setOnClickListener { v ->
      adapter.filter.filter(AdvertTypeEnum.USED.name, listener)
      v.isEnabled = false
      newfilter.isEnabled = true
      disablefilter.isEnabled = true
    }

    disablefilter.isEnabled = false
    adapter.filter.filter("", listener)

  }

  companion object {

    fun newInstance(advertsList: List<AdvertsItem?>?): AdvertsFragment {

      // Create a new AdvertFragment and set the Bundle as the arguments
      val fragment = AdvertsFragment()
      fragment.retainInstance = true

      //Drop first element (offer already display on header)
      fragment.advertsList = advertsList!!.drop(1) as ArrayList<AdvertsItem?>

      return fragment
    }
  }
}