package com.kfadli.pminister.activity.main

import com.kfadli.pminister.activity.base.IView

interface IMainView : IView{
  fun onDataReceived()
  fun onDataFailed()
}