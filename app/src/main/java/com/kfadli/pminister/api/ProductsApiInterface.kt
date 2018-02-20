package com.kfadli.pminister.api

import com.kfadli.pminister.response.ResponseList
import com.kfadli.pminister.response.ResponseDetail
import io.reactivex.Observable
import retrofit2.http.GET

interface ProductsApiInterface {

  @GET("k07iv")
  fun getProductsList(): Observable<ResponseList>

  @GET("q0oqf")
  fun getProductDetail(): Observable<ResponseDetail>
}
