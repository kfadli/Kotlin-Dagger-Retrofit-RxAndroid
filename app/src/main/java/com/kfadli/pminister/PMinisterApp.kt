package com.kfadli.pminister

import android.app.Activity
import android.app.Application
import com.kfadli.pminister.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class PMinisterApp : Application(), HasActivityInjector {

  @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>


  override fun onCreate() {
    super.onCreate()

    DaggerAppComponent.create()
        .inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return activityInjector
  }
}

