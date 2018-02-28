package com.kfadli.pminister.activity.main.impl

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.View
import com.kfadli.pminister.R
import com.kfadli.pminister.R.layout
import com.kfadli.pminister.activity.base.BaseActivity
import com.kfadli.pminister.activity.main.IMainPresenter
import com.kfadli.pminister.activity.main.IMainView
import com.kfadli.pminister.activity.main.adapter.RecyclerProductsAdapter
import com.kfadli.pminister.api.ProductsApiInterface
import com.kfadli.pminister.components.fromView
import com.kfadli.pminister.response.ProductsItem
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.product_list
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.toolbar
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject


class MainActivity : BaseActivity<IMainView, IMainPresenter>(), IMainView {

  private val TAG: String = "MainActivity"


  override lateinit var presenter: IMainPresenter

  private lateinit var searchView: SearchView
  private lateinit var adapter: RecyclerProductsAdapter

  @Inject
  lateinit var apiService: ProductsApiInterface

  val disposables = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    setSupportActionBar(toolbar)


    presenter = MainPresenter(this, apiService)

    product_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    product_list.setHasFixedSize(true)
    product_list.layoutManager = LinearLayoutManager(this)

    presenter.fetchData()
  }

  override fun onDestroy() {
    disposables.clear()
    super.onDestroy()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)

    val search = menu.findItem(R.id.search)
    searchView = (search.actionView as SearchView)

    //SearchFilter configuration
    disposables.add(fromView(searchView)
        .debounce(300, MILLISECONDS)
        .filter { keyword -> !keyword.isNullOrEmpty() && keyword.length > 3 }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ text ->
          Log.d(TAG, "[onSearchUpdate] search:" + text)
          adapter.filter.filter(text)
        }))

    return true
  }

  override fun onDataReceived(
      products: List<ProductsItem?>?) {

    adapter = RecyclerProductsAdapter(products)

    product_list.adapter = adapter
    adapter.filter.filter("")
  }

  override fun onDataFailed() {
    showError("[onDataFailed]")
    showRetryDialog(R.string.application_has_encountered_error,
        DialogInterface.OnClickListener { dialog, which -> presenter.fetchData(); dialog.dismiss() })
  }

  override fun showLoader() {
    progressBar.visibility = View.VISIBLE
  }

  override fun hideLoader() {
    progressBar.visibility = View.INVISIBLE
  }

}
