package com.kfadli.pminister.di

import com.kfadli.pminister.PMinisterApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class,
    ApiModule::class,
    ActivitiesModule::class
))
interface AppComponent {
  fun inject(app: PMinisterApp)
}

