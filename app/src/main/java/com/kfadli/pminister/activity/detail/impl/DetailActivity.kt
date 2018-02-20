package com.kfadli.pminister.activity.detail.impl

import android.os.Bundle
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.activity.detail.adapter.ImagePagerAdapter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ResultDetail
import com.kfadli.pminister.util.filterUrlByFormat
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.gallery_viewpager
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.content_detail.reviews_txt
import kotlinx.android.synthetic.main.content_detail.title_txt
import javax.inject.Inject
import com.kfadli.pminister.R.id.viewPager
import com.itsronald.widget.ViewPagerIndicator
import android.view.Gravity
import android.R.attr.gravity
import android.graphics.Color
import android.support.v4.view.ViewPager
import android.view.ViewGroup.LayoutParams


class DetailActivity : BaseActivity<IDetailView, IDetailPresenter>(), IDetailView {

  @Inject
  lateinit var apiService: ProductsApiInterface

  lateinit override var presenter: IDetailPresenter


  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)
    setSupportActionBar(toolbar)

    presenter = DetailPresenter(this, apiService)

    val layoutParams = ViewPager.LayoutParams()
    layoutParams.width = LayoutParams.MATCH_PARENT
    layoutParams.height = LayoutParams.WRAP_CONTENT
    layoutParams.gravity = Gravity.BOTTOM

    val viewPagerIndicator = ViewPagerIndicator(this)
    viewPagerIndicator.selectedDotColor = Color.BLACK
    gallery_viewpager.addView(viewPagerIndicator, layoutParams)

  }

  override fun onDataReceived(product: ResultDetail?) {

    val urls: List<String> = filterUrlByFormat(product?.images, "LARGE")
    gallery_viewpager.adapter = ImagePagerAdapter(supportFragmentManager, urls)

    title_txt.text = product!!.headline
    reviews_txt.text = product.nbReviews.toString()

  }

  override fun onDataFailed() {
  }
}
