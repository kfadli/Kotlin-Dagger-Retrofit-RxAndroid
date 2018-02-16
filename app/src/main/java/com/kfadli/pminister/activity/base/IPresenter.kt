package com.kfadli.pminister.activity.base

interface IPresenter<in V : IView> {

  fun subscribe()

  fun unsubscribe()

}