package com.kfadli.pminister.activity.detail.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.detail.fragment.content.AdvertsFragment
import com.kfadli.pminister.activity.detail.fragment.content.EditoFragment
import com.kfadli.pminister.activity.detail.fragment.content.ReviewsFragment
import com.kfadli.pminister.response.ResultDetail

class ContentProductAdapter(val context: Context, fragmentManager: FragmentManager,
    val product: ResultDetail) : FragmentStatePagerAdapter(fragmentManager) {

  override fun getCount(): Int {
    return 3
  }

  override fun getItem(position: Int): Fragment {
    when (position) {
      0 -> return AdvertsFragment.newInstance(product.adverts!!)
      1 -> return ReviewsFragment.newInstance(product.reviews)
      2 -> return EditoFragment.newInstance(product.edito!!)
    }

    return Fragment()
  }

  override fun getPageTitle(position: Int): CharSequence? {
    when (position) {
      0 -> return context.getString(R.string.adverts).toUpperCase()
      1 -> return context.getString(R.string.reviews).toUpperCase()
      2 -> return context.getString(R.string.edito).toUpperCase()
    }
    return ""
  }
}