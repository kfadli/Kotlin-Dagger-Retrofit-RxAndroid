package com.kfadli.pminister.di;

import com.kfadli.pminister.BuildConfig
import com.kfadli.pminister.api.ProductsApiInterface;
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson



@Module public class ApiModule {

  @Provides
  fun provideRetrofit(): Retrofit {

    val okHttpBuilder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
      val httpLoggingInterceptor = HttpLoggingInterceptor()
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      okHttpBuilder.addInterceptor(httpLoggingInterceptor)
    }

    okHttpBuilder.addInterceptor({
      val request = it.request()
      val url = request.url().newBuilder()
          .build()
      it.proceed(request.newBuilder().url(url).build())
    })

    val gson = GsonBuilder()
        .setLenient()
        .create()


    return Retrofit.Builder()
        .baseUrl("https://api.myjson.com/bins/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpBuilder.build())
        .build()

  }

  @Singleton
  @Provides
  fun provideProductsApiInterface(retrofit: Retrofit): ProductsApiInterface =
      retrofit.create(ProductsApiInterface::class.java)

}
