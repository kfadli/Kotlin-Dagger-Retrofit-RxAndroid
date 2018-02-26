package com.kfadli.pminister.activity.detail.impl

import android.util.Log
import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.api.ProductsApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(var view: IDetailView, var api: ProductsApiInterface) : IDetailPresenter {

  private val TAG = "DetailPresenter"

  var disposables: CompositeDisposable = CompositeDisposable()

  override fun fetchData() {
    disposables.add(
        api.getProductDetail()
            .filter({ view != null })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
              view.hideLoader()
              view.onDataReceived(t.result)
            },
                { t ->
                  Log.d(TAG, "[subscribe] failed", t)
                  view.hideLoader()
                  view.onDataFailed()
                }))
  }

  override fun subscribe() {
  }

  override fun unsubscribe() {
    disposables.clear()
  }

}