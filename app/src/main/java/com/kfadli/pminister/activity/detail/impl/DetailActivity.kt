package com.kfadli.pminister.activity.detail.impl

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import com.itsronald.widget.ViewPagerIndicator
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.base.adapter.ImagePagerAdapter
import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.activity.detail.adapter.ContentProductAdapter
import com.kfadli.pminister.activity.gallery.GalleryActivity
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.enums.FormatEnum.LARGE
import com.kfadli.pminister.enums.FormatEnum.ORIGINAL
import com.kfadli.pminister.enums.QualityEnum
import com.kfadli.pminister.response.ResultDetail
import com.kfadli.pminister.util.Constant
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.filterUrlByFormat
import com.kfadli.pminister.util.formatSellsAndReviews
import com.kfadli.pminister.util.toString
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.gallery_viewpager
import kotlinx.android.synthetic.main.activity_detail.progressBar
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.content_detail.best_price_txt
import kotlinx.android.synthetic.main.content_detail.label_recommendation
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

  override lateinit var presenter: IDetailPresenter


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
    val urls: ArrayList<String> = filterUrlByFormat(product?.images, LARGE.toString())

    //Handle ViewPager onClick
    gallery_viewpager.adapter = ImagePagerAdapter(
        supportFragmentManager, urls, View.OnClickListener { v ->

      val originalUrl: ArrayList<String> = filterUrlByFormat(product?.images, ORIGINAL.toString())
      val intent = Intent(getContext(), GalleryActivity::class.java)
      intent.putStringArrayListExtra(Constant.IMAGE_URLS, originalUrl)

      startActivity(intent)
    })


    val bestOffer = product!!.adverts!![0]

    //Set some view properties
    score.visibility = View.VISIBLE
    label_recommendation.text = getString(R.string.recommended_offer)
    title_txt.text = product.headline
    reviews_txt.text = "${product.nbReviews.toString()} ${getString(R.string.reviews)}"
    best_price_txt.text = currencyFormat().format(product.summaryBestPrice!!.toDouble())
    score.rating = product.reviewsAverageNote?.toFloat()!!
    quality_product_txt.text = QualityEnum.valueOf(bestOffer?.quality!!).toString(this)
    username_txt.text = bestOffer.seller?.login
    sells_review_txt.text = bestOffer.seller!!.formatSellsAndReviews(this)

    //Populate content
    viewPager.adapter = ContentProductAdapter(this, supportFragmentManager, product)


  }

  /**
   * Method failed to retrieve Data from WebService
   */
  override fun onDataFailed() {
    showRetryDialog(R.string.application_has_encountered_error,
        DialogInterface.OnClickListener { dialog, which -> presenter.fetchData(); dialog.dismiss() })
  }

  override fun showLoader() {
    progressBar.visibility = View.VISIBLE
  }

  override fun hideLoader() {
    progressBar.visibility = View.INVISIBLE
  }
}
