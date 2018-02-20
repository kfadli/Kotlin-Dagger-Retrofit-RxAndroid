package com.kfadli.pminister.activity.detail

import com.kfadli.pminister.activity.base.IView
import com.kfadli.pminister.response.ResultDetail

interface IDetailView : IView {
  fun onDataReceived(product: ResultDetail?)

  fun onDataFailed()
}