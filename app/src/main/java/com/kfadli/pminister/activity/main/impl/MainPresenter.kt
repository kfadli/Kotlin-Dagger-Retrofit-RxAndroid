package com.kfadli.pminister.activity.main.impl

import android.content.ContentValues.TAG
import android.util.Log
import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.api.ProductsApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainPresenter(var view: IMainView, var api: ProductsApiInterface) : IMainPresenter {

  var disposables: CompositeDisposable = CompositeDisposable();

  override fun fetchData() {
  }

  override fun subscribe() {
    disposables.add(
        api.getProductsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { t -> view.onDataReceived() }))
  }

  override fun unsubscribe() {
  }

}