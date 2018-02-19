package com.kfadli.pminister.api

import com.kfadli.pminister.response.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface ProductsApiInterface {

  @GET("k07iv")
  fun getProductsList(): Observable<Response>

  @GET("q0oqf")
  fun getProductDetail(): Observable<Response>
}
