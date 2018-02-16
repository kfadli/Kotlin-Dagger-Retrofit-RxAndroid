package com.kfadli.pminister.activity.main.impl

import android.os.Bundle
import com.kfadli.pminister.R.layout
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.api.ProductsApiInterface
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity<IMainView, IMainPresenter>(), IMainView {

  lateinit override var presenter: IMainPresenter

  @Inject lateinit var apiService: ProductsApiInterface;


  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    presenter = MainPresenter(this, apiService)
  }

  override fun onDataReceived() {
    showError("[onDataReceived]")
  }

  override fun onDataFailed() {
    showError("[onDataFailed]")
  }
}
