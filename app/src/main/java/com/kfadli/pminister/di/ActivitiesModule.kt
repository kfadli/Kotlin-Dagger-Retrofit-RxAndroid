package com.kfadli.pminister.di

import com.kfadli.pminister.activity.detail.di.DetailModule
import com.kfadli.pminister.activity.detail.impl.DetailActivity
import com.kfadli.pminister.activity.main.di.MainModule
import com.kfadli.pminister.activity.main.impl.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
  @ActivityScope
  @ContributesAndroidInjector(modules = [(MainModule::class)])
  abstract fun provideMainActivityInjector(): MainActivity

  @ActivityScope
  @ContributesAndroidInjector(modules = [(DetailModule::class)])
  abstract fun provideDetailActivityInjector(): DetailActivity
}

annotation class ActivityScope
