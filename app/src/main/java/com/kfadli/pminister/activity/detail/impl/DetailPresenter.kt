package com.kfadli.pminister.activity.detail.impl

import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.api.ProductsApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(var view: IDetailView, var api: ProductsApiInterface) : IDetailPresenter {

  var disposables: CompositeDisposable = CompositeDisposable()

  override fun fetchData() {
  }

  override fun subscribe() {
    disposables.add(
        api.getProductDetail()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> view.onDataReceived(t.result)}))

  }

  override fun unsubscribe() {
    disposables.clear()
  }

}