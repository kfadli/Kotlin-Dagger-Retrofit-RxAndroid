package com.kfadli.pminister.activity.main.impl

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.kfadli.pminister.R.attr
import com.kfadli.pminister.R.layout
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.activity.main.adapter.RecyclerProductsAdapter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ProductsItem
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

class MainActivity : BaseActivity<IMainView, IMainPresenter>(), IMainView {

  lateinit override var presenter: IMainPresenter

  private lateinit var adapter: RecyclerProductsAdapter

  @Inject lateinit var apiService: ProductsApiInterface


  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    presenter = MainPresenter(this, apiService)

    product_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    product_list.setHasFixedSize(true)
    product_list.layoutManager = LinearLayoutManager(this)
  }


  override fun onDataReceived(
      products: List<ProductsItem?>?) {

    showMessage("[onDataReceived]")

    adapter = RecyclerProductsAdapter(products)

    product_list.adapter = adapter

  }

  override fun onDataFailed() {
    showError("[onDataFailed]")
  }
}
