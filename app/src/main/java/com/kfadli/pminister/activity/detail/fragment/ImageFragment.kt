package com.kfadli.pminister.activity.detail.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kfadli.pminister.R
import com.kfadli.pminister.util.Constant
import com.kfadli.pminister.util.loadUrl
import kotlinx.android.synthetic.main.fragment_image.image_gallery

class ImageFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {

    // Creates the view controlled by the fragment
    val view = inflater.inflate(R.layout.fragment_image, container, false)

    val imageView = view.findViewById<ImageView>(R.id.image_gallery)

    // Retrieve and display the image data from the Bundle
    val args = arguments

    // Download the image and display it using Picasso
    imageView.loadUrl(args.getString(Constant.IMAGE_URL))
    return view
  }

  companion object {

    fun newInstance(image: String): ImageFragment {
      // Store the image data in a Bundle object
      val args = Bundle()
      args.putString(Constant.IMAGE_URL, image)

      // Create a new ImageFragment and set the Bundle as the arguments
      val fragment = ImageFragment()
      fragment.arguments = args
      return fragment
    }
  }
}