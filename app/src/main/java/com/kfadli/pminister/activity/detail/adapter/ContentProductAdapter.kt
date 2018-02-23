package com.kfadli.pminister.activity.detail.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kfadli.pminister.activity.detail.fragment.edito.EditoFragment
import com.kfadli.pminister.activity.detail.fragment.edito.ReviewsFragment
import com.kfadli.pminister.response.ResultDetail

class ContentProductAdapter(fragmentManager: FragmentManager,
    val product: ResultDetail) : FragmentStatePagerAdapter(fragmentManager) {

  override fun getCount(): Int {
    return 2
  }

  override fun getItem(position: Int): Fragment {
    when (position) {
      1 -> return ReviewsFragment.newInstance(product.reviews)
      0 -> return EditoFragment.newInstance(product.edito!!)
    }

    return Fragment()
  }


}