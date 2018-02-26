package com.kfadli.pminister.activity.detail.impl

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog.Builder
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
import com.kfadli.pminister.util.QualityEnum
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.filterUrlByFormat
import com.kfadli.pminister.util.formatSellsAndReviews
import com.kfadli.pminister.util.toString
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.gallery_viewpager
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.content_detail.best_price_txt
import kotlinx.android.synthetic.main.content_detail.quality_product_txt
import kotlinx.android.synthetic.main.content_detail.reviews_txt
import kotlinx.android.synthetic.main.content_detail.score
import kotlinx.android.synthetic.main.content_detail.sells_review_txt
import kotlinx.android.synthetic.main.content_detail.tabs_layout
import kotlinx.android.synthetic.main.content_detail.title_txt
import kotlinx.android.synthetic.main.content_detail.username_txt
import kotlinx.android.synthetic.main.content_detail.viewPager
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


    //Prepare LayoutParams
    val layoutParams = ViewPager.LayoutParams()
    layoutParams.width = LayoutParams.MATCH_PARENT
    layoutParams.height = LayoutParams.WRAP_CONTENT
    layoutParams.gravity = Gravity.BOTTOM

    //add ViewPagerIndicator gallery bottom
    val viewPagerIndicator = ViewPagerIndicator(this)
    viewPagerIndicator.selectedDotColor = Color.BLACK
    gallery_viewpager.addView(viewPagerIndicator, layoutParams)

    //Disable HorizontalScroll
    viewPager.setOnTouchListener({ v, event -> true })

    //Setup Content ViewPager
    tabs_layout.setupWithViewPager(viewPager)

    presenter.fetchData()
  }

  /**
   * Method handle Data from WebService
   */
  override fun onDataReceived(product: ResultDetail?) {

    //Find all url Images with LARGE format
    val urls: List<String> = filterUrlByFormat(product?.images, "LARGE")
    gallery_viewpager.adapter = ImagePagerAdapter(supportFragmentManager, urls)


    val bestOffer = product!!.adverts!![0]
    //Set some view properties
    title_txt.text = product.headline
    reviews_txt.text = "${product.nbReviews.toString()} ${getString(R.string.reviews)}"
    best_price_txt.text = currencyFormat().format(product.summaryBestPrice!!.toDouble())
    score.rating = product.reviewsAverageNote?.toFloat()!!
    quality_product_txt.text = QualityEnum.valueOf(bestOffer?.quality!!).toString(this)
    username_txt.text = bestOffer.seller?.login
    sells_review_txt.text = bestOffer.seller!!.formatSellsAndReviews(this)

    viewPager.adapter = ContentProductAdapter(this, supportFragmentManager, product)
  }

  /**
   * Method failed to retrieve Data from WebService
   */
  override fun onDataFailed() {
    val dialogBuilder = Builder(this).create()
    dialogBuilder.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.retry),
        { dialog, which -> presenter.fetchData(); dialog.dismiss() })
    dialogBuilder.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.cancel),
        { dialog, which -> dialog.dismiss() })
    dialogBuilder.setMessage(getString(R.string.something_went_wrong))

    if (!isFinishing) {
      dialogBuilder.show()
    }
  }
}
