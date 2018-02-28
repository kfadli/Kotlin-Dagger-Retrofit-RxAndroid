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
        disposables.add(
                api.getProductsList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ t ->
                            println("Subscribe")
                            view.hideLoader()
                            view.onDataReceived(t.result?.products)
                        },
                                {
                                    println("throw")
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