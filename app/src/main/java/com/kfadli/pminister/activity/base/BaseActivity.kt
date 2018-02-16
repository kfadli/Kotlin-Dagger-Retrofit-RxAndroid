package com.kfadli.pminister.activity.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

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
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
  }

  override fun showError(stringResId: Int) {
    Toast.makeText(this, stringResId, Toast.LENGTH_SHORT).show()
  }

  override fun showMessage(srtResId: Int) {
    Toast.makeText(this, srtResId, Toast.LENGTH_SHORT).show()
  }

  override fun showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }

}