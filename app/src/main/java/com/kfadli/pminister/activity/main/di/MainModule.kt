package com.kfadli.pminister.activity.main.di

import com.kfadli.pminister.activity.main.impl.MainActivity
import com.kfadli.pminister.activity.main.impl.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

  @Binds
  abstract fun bindPresenter(mainPresenter: MainPresenter): MainPresenter

  @Binds
  abstract fun bindView(mainActivity: MainActivity): MainActivity

}