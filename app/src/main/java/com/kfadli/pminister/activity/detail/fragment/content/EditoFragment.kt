package com.kfadli.pminister.activity.detail.fragment.content

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kfadli.pminister.R
import com.kfadli.pminister.util.TextViewUtils
import kotlinx.android.synthetic.main.fragment_edito.edito_html_txt

class EditoFragment : Fragment() {

  lateinit var content: String

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {

    // Creates the view controlled by the fragment
    val view = inflater.inflate(R.layout.fragment_edito, container, false)


    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val textView = view.findViewById<TextView>(R.id.edito_html_txt)
    edito(content, textView)

  }

  private fun edito(edito: String?, textView: TextView) {
    if (VERSION.SDK_INT >= VERSION_CODES.N) {
      textView.text = Html.fromHtml(edito, Html.FROM_HTML_MODE_COMPACT,
          TextViewUtils.PicassoImageGetter(edito_html_txt), null)
    } else {
      textView.text = Html.fromHtml(edito)
    }

  }

  companion object {

    fun newInstance(edito: String?): EditoFragment {
      // Create a new ImageFragment and set the Bundle as the arguments
      val fragment = EditoFragment()
      fragment.content = edito!!

      return fragment
    }
  }
}