package com.kfadli.pminister.activity.detail.impl

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.ViewGroup.LayoutParams
import com.itsronald.widget.ViewPagerIndicator
import com.kfadli.pminister.R
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.activity.detail.adapter.ImagePagerAdapter
import com.kfadli.pminister.activity.detail.fragment.content.AdvertsFragment
import com.kfadli.pminister.activity.detail.fragment.content.EditoFragment
import com.kfadli.pminister.activity.detail.fragment.content.ReviewsFragment
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ResultDetail
import com.kfadli.pminister.util.currencyFormat
import com.kfadli.pminister.util.filterUrlByFormat
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
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

    }

    override fun onDataReceived(product: ResultDetail?) {

        //Find all url Images with LARGE format
        val urls: List<String> = filterUrlByFormat(product?.images, "LARGE")
        gallery_viewpager.adapter = ImagePagerAdapter(supportFragmentManager, urls)

        title_txt.text = product!!.headline
        reviews_txt.text = product.nbReviews.toString()
        best_price_txt.text = currencyFormat().format(product.summaryBestPrice!!.toDouble())

        tabs_layout.setupWithViewPager(viewPager)
        viewPager.adapter = ContentProductAdapter(supportFragmentManager, product)

        score.rating = product.reviewsAverageNote?.toFloat()!!
    }

    override fun onDataFailed() {
    }

    inner class ContentProductAdapter(fragmentManager: FragmentManager,
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
                0 -> return getString(R.string.adverts).toUpperCase()
                1 -> return getString(R.string.reviews).toUpperCase()
                2 -> return getString(R.string.edito).toUpperCase()
            }

            return ""
        }
    }
}
