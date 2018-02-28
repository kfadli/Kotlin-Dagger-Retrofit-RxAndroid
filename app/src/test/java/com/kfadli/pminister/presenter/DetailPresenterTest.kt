package com.kfadli.pminister.presenter

import com.kfadli.pminister.activity.detail.IDetailPresenter
import com.kfadli.pminister.activity.detail.IDetailView
import com.kfadli.pminister.activity.detail.impl.DetailPresenter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ResponseDetail
import com.kfadli.pminister.rule.RxSchedulerRule
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.io.IOException
import org.mockito.Mockito.`when` as whenever


/**
 * Basic Test for DetailPresenter
 */
class DetailPresenterTest {

  @Rule
  @JvmField
  val schedulers = RxSchedulerRule()

  @Mock
  lateinit var view: IDetailView

  @Mock
  lateinit var api: ProductsApiInterface

  lateinit var presenter: IDetailPresenter


  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    presenter = DetailPresenter(view, api)
  }

  @Test
  fun should_fetchData() {
    whenever(api.getProductDetail()).thenReturn(Observable.just(mock(ResponseDetail::class.java)))

    presenter.fetchData()

    Mockito.verify(api, times(1)).getProductDetail()
  }

  @Test
  fun should_hideLoader_onSuccess() {
    whenever(api.getProductDetail()).thenReturn(Observable.just(mock(ResponseDetail::class.java)))

    presenter.fetchData()

    Mockito.verify(view, times(1)).hideLoader()
  }

  @Test
  fun should_hideLoader_onFailed() {
    whenever(api.getProductDetail()).thenReturn(
        Observable.create { emitter -> emitter.onError(IOException(":(")) })

    presenter.fetchData()

    Mockito.verify(view, times(1)).hideLoader()
  }

  @Test
  fun should_onDataReceived() {
    whenever(api.getProductDetail()).thenReturn(Observable.just(mock(ResponseDetail::class.java)))

    presenter.fetchData()

    Mockito.verify(view, times(1)).onDataReceived(any())
  }

  @Test
  fun should_onDataFailed() {
    whenever(api.getProductDetail()).thenReturn(
        Observable.create { emitter -> emitter.onError(IOException(":(")) })

    presenter.fetchData()

    Mockito.verify(view, times(1)).onDataFailed()
  }

}
