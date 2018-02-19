package com.kfadli.pminister.activity.main

import com.kfadli.pminister.activity.base.IView
import com.kfadli.pminister.response.ProductsItem

interface IMainView : IView {
  fun onDataReceived(
      products: List<ProductsItem?>?)

  fun onDataFailed()
}