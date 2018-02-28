package com.kfadli.pminister.presenter

import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.activity.main.impl.MainPresenter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.response.ResponseList
import com.kfadli.pminister.rule.RxSchedulerRule
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS
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
    fun should_fetch_ResponseList_from_api() {
        whenever(api.getProductsList()).thenReturn(Observable.just(mock(ResponseList::class.java)))

        presenter.fetchData()

        Mockito.verify(api, times(1)).getProductsList()
    }

    @Test
    fun should_hide_dialog_onSuccess() {
        whenever(api.getProductsList()).thenReturn(Observable.just(mock(ResponseList::class.java)))

        presenter.fetchData()

        Mockito.verify(view, times(1)).hideLoader()
    }

    @Test
    fun should_call_onSuccess() {
        whenever(api.getProductsList()).thenReturn(Observable.just(mock(ResponseList::class.java)))

        presenter.fetchData()

        Mockito.verify(view, times(1)).onDataReceived(any())
    }


    @Test
    fun should_hide_dialog_onFailed() {
        //whenever(api.getProductsList()).thenReturn())


        presenter.fetchData()

        Mockito.verify(view, times(1)).hideLoader()
        Mockito.verify(view, times(1)).onDataFailed()

    }


}
