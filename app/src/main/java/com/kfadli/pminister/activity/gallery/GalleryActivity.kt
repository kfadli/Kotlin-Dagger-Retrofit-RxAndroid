package com.kfadli.pminister.activity.gallery

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import com.itsronald.widget.ViewPagerIndicator
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.base.adapter.ImagePagerAdapter
import com.kfadli.pminister.util.Constant
import kotlinx.android.synthetic.main.activity_detail.gallery_viewpager

class GalleryActivity : AppCompatActivity() {

  private val TAG = "GalleryActivity"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_gallery)

    //Prepare LayoutParams
    val layoutParams = ViewPager.LayoutParams()
    layoutParams.width = LayoutParams.MATCH_PARENT
    layoutParams.height = LayoutParams.WRAP_CONTENT
    layoutParams.gravity = Gravity.BOTTOM

    //add ViewPagerIndicator gallery bottom
    val viewPagerIndicator = ViewPagerIndicator(this)
    viewPagerIndicator.selectedDotColor = Color.BLACK
    gallery_viewpager.addView(viewPagerIndicator, layoutParams)

    val urls = intent.getStringArrayListExtra(Constant.IMAGE_URLS)

    Log.d(TAG, "[onCreate] urls:" + urls.size)

    gallery_viewpager.adapter = ImagePagerAdapter(
        supportFragmentManager, urls, View.OnClickListener { })
  }

  override fun onBackPressed() {
    super.onBackPressed()

    finish()
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
  }
}