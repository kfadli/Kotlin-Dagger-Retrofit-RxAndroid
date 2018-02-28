package com.kfadli.pminister.presenter

import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.activity.main.impl.MainPresenter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ResponseList
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
 * Basic Test for MainPresenter
 */
class MainPresenterTest {

  @Rule
  @JvmField
  val schedulers = RxSchedulerRule()

  @Mock
  lateinit var view: IMainView

  @Mock
  lateinit var api: ProductsApiInterface

  lateinit var presenter: IMainPresenter


  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    presenter = MainPresenter(view, api)
  }

  @Test
  fun should_fetchData() {
    whenever(api.getProductsList()).thenReturn(Observable.just(mock(ResponseList::class.java)))

    presenter.fetchData()

    Mockito.verify(api, times(1)).getProductsList()
  }

  @Test
  fun should_hideLoader_onSuccess() {
    whenever(api.getProductsList()).thenReturn(Observable.just(mock(ResponseList::class.java)))

    presenter.fetchData()

    Mockito.verify(view, times(1)).hideLoader()
  }

  @Test
  fun should_onDataReceived() {
    whenever(api.getProductsList()).thenReturn(Observable.just(mock(ResponseList::class.java)))

    presenter.fetchData()

    Mockito.verify(view, times(1)).onDataReceived(any())
  }


  @Test
  fun should_hideLoader_onFailed() {
    whenever(api.getProductsList()).thenReturn(
        Observable.create { emitter -> emitter.onError(IOException(":(")) })

    presenter.fetchData()

    Mockito.verify(view, times(1)).hideLoader()
  }

  @Test
  fun should_onDataFailed() {
    whenever(api.getProductsList()).thenReturn(
        Observable.create { emitter -> emitter.onError(IOException(":(")) })

    presenter.fetchData()

    Mockito.verify(view, times(1)).onDataFailed()
  }

}
