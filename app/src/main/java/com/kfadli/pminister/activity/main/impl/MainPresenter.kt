package com.kfadli.pminister.activity.main.impl

import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.api.ProductsApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(var view: IMainView, var api: ProductsApiInterface) : IMainPresenter {

  var disposables: CompositeDisposable = CompositeDisposable()

  override fun fetchData() {
  }

  override fun subscribe() {
    disposables.add(
        api.getProductsList()
            .filter({ view != null })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
              view.hideLoader()
              view.onDataReceived(t.result?.products)
            },
                {
                  view.hideLoader()
                  view.onDataFailed()
                }))
  }

  override fun unsubscribe() {
    disposables.clear()
  }

}