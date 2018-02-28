package com.kfadli.pminister.api

import com.kfadli.pminister.response.ResponseDetail
import com.kfadli.pminister.response.ResponseList
import com.kfadli.pminister.util.Constant
import io.reactivex.Observable
import retrofit2.http.GET

interface ProductsApiInterface {

  @GET(Constant.LIST_PATH)
  fun getProductsList(): Observable<ResponseList>

  @GET(Constant.DETAIL_PATH)
  fun getProductDetail(): Observable<ResponseDetail>
}
