package com.kfadli.pminister.activity.detail

import com.kfadli.pminister.activity.base.IPresenter

interface IDetailPresenter : IPresenter<IDetailView> {
  fun fetchData()
}