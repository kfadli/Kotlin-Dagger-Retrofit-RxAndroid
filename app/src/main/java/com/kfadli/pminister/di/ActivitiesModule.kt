package com.kfadli.pminister.di

import com.kfadli.pminister.activity.main.di.MainModule
import com.kfadli.pminister.activity.main.impl.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
  @ActivityScope
  @ContributesAndroidInjector(modules = [(MainModule::class)])
  abstract fun provideMainActivityInjector(): MainActivity
}

annotation class ActivityScope
