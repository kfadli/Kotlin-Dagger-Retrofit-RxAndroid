package com.kfadli.pminister.activity.base

import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.support.v7.app.AlertDialog.Builder
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kfadli.pminister.R
import com.kfadli.pminister.R.style

abstract class BaseActivity<in V : IView, T : IPresenter<V>> : AppCompatActivity(), IView {

  protected abstract var presenter: T

  override fun onStart() {
    super.onStart()
    presenter.subscribe()
  }

  override fun onDestroy() {
    presenter.unsubscribe()
    super.onDestroy()
  }

  override fun getContext(): Context = this


  override fun showError(error: String?) {
    if (!isFinishing) {
      Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
  }

  override fun showError(resId: Int) {
    if (!isFinishing) {
      Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }
  }

  override fun showMessage(resId: Int) {
    if (!isFinishing) {
      Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }
  }

  override fun showMessage(message: String) {
    if (!isFinishing) {
      Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
  }

  override fun showRetryDialog(resId: Int, listener: OnClickListener) {

    if (!isFinishing) {
      val dialogBuilder = Builder(this, style.error_dialog).create()
      dialogBuilder.setCancelable(false)
      dialogBuilder.setTitle(R.string.oops_something_went_wrong)
      dialogBuilder.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.retry), listener)
      dialogBuilder.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.cancel),
          { dialog, which -> dialog.dismiss(); finish() })
      dialogBuilder.setMessage(getString(resId))
      dialogBuilder.show()
    }
  }


}