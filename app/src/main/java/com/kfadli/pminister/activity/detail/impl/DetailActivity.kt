package com.kfadli.pminister.activity.detail.impl

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.ViewGroup.LayoutParams
import com.itsronald.widget.ViewPagerIndicator
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.activity.detail.adapter.ContentProductAdapter
import com.kfadli.pminister.activity.detail.adapter.ImagePagerAdapter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ResultDetail
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.filterUrlByFormat
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.gallery_viewpager
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.content_detail.best_price_txt
import kotlinx.android.synthetic.main.content_detail.reviews_txt
import kotlinx.android.synthetic.main.content_detail.score
import kotlinx.android.synthetic.main.content_detail.title_txt
import kotlinx.android.synthetic.main.content_detail.viewPager
import kotlinx.android.synthetic.main.review.date_txt
import javax.inject.Inject


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


    //prepare LayoutParams
    val layoutParams = ViewPager.LayoutParams()
    layoutParams.width = LayoutParams.MATCH_PARENT
    layoutParams.height = LayoutParams.WRAP_CONTENT
    layoutParams.gravity = Gravity.BOTTOM

    //add ViewPagerIndicator gallery bottom
    val viewPagerIndicator = ViewPagerIndicator(this)
    viewPagerIndicator.selectedDotColor = Color.BLACK
    gallery_viewpager.addView(viewPagerIndicator, layoutParams)
  }

  override fun onDataReceived(product: ResultDetail?) {

    val urls: List<String> = filterUrlByFormat(product?.images, "LARGE")
    gallery_viewpager.adapter = ImagePagerAdapter(supportFragmentManager, urls)

    title_txt.text = product!!.headline
    reviews_txt.text = product.nbReviews.toString()
    best_price_txt.text = currencyFormat().format(product.summaryBestPrice!!.toDouble())

    viewPager.adapter = ContentProductAdapter(supportFragmentManager, product)
    score.rating = product.reviewsAverageNote?.toFloat()!!
  }

  override fun onDataFailed() {
  }
}
