package com.kfadli.pminister.activity.base.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kfadli.pminister.activity.base.fragment.ImageFragment

class ImagePagerAdapter(fragmentManager: FragmentManager,
    private val pictures: List<String>) :
    FragmentStatePagerAdapter(fragmentManager) {

  override fun getItem(position: Int): Fragment {
    return ImageFragment.newInstance(pictures[position])
  }

  override fun getCount(): Int {
    return pictures.size
  }
}