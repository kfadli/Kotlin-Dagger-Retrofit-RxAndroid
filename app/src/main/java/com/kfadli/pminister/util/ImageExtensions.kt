package com.kfadli.pminister.util

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

fun ImageView.loadUrl(url: String) {
  Picasso.with(this.context).load(url).into(this)
}

inline fun ImageView.loadUrl(url: String, callback: KCallback.() -> Unit) {
  Picasso.with(this.context).load(url).intoWithCallback(this, callback)
}

inline fun RequestCreator.intoWithCallback(target: ImageView, callback: KCallback.() -> Unit) {
  this.into(target, KCallback().apply(callback))
}

class KCallback : Callback {

  private var onSuccess: (() -> Unit)? = null
  private var onError: (() -> Unit)? = null

  override fun onSuccess() {
    onSuccess?.invoke()
  }

  override fun onError() {
    onError?.invoke()
  }

  fun onSuccess(function: () -> Unit) {
    this.onSuccess = function
  }

  fun onError(function: () -> Unit) {
    this.onError = function
  }
}