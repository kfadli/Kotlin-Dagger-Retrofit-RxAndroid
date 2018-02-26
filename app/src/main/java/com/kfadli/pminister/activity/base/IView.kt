package com.kfadli.pminister.activity.base

import android.content.Context
import android.support.annotation.StringRes

interface IView {

  fun getContext(): Context

  fun showError(error: String?)

  fun showError(@StringRes resId: Int)

  fun showMessage(@StringRes resId: Int)

  fun showMessage(message: String)

  fun showLoader()

  fun hideLoader()

}