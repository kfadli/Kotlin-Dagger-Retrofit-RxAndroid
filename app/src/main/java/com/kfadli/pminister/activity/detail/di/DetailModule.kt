package com.kfadli.pminister.activity.detail.di

import com.kfadli.pminister.activity.detail.impl.DetailActivity
import com.kfadli.pminister.activity.detail.impl.DetailPresenter
import com.kfadli.pminister.activity.main.impl.MainActivity
import com.kfadli.pminister.activity.main.impl.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class DetailModule {

  @Binds
  abstract fun bindPresenter(detailPresenter: DetailPresenter): DetailPresenter

  @Binds
  abstract fun bindView(detailActivity: DetailActivity): DetailActivity

}