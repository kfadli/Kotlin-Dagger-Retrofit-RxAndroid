package com.kfadli.pminister.activity.main

import com.kfadli.pminister.activity.base.IPresenter

interface IMainPresenter : IPresenter<IMainView> {
  fun fetchData()
}