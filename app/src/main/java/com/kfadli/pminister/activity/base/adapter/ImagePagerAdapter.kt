package com.kfadli.pminister.activity.base.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View.OnClickListener
import com.kfadli.pminister.activity.base.fragment.ImageFragment

class ImagePagerAdapter(fragmentManager: FragmentManager,
    private val images: List<String>?,
    private val onClickListener: OnClickListener) :
FragmentStatePagerAdapter(fragmentManager) {

  override fun getItem(position: Int): Fragment {
    return ImageFragment.newInstance(images!![position], onClickListener)
  }

  override fun getCount(): Int {
    return images!!.size
  }
}