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
import javax.inject.Inject

class DetailActivity : BaseActivity<IDetailView, IDetailPresenter>(), IDetailView {

  @Inject lateinit var apiService: ProductsApiInterface

  lateinit override var presenter: IDetailPresenter



  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)
    setSupportActionBar(toolbar)

    presenter = DetailPresenter(this, apiService)
  }

  override fun onDataReceived(product: ResultDetail?) {

    val urls: List<String> = filterUrlByFormat(product?.images, "LARGE")
    gallery_viewpager.adapter = ImagePagerAdapter(supportFragmentManager, urls)
  }

  override fun onDataFailed() {
  }
}
