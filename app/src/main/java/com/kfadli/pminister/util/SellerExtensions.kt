package com.kfadli.pminister.util

import android.content.Context
import com.kfadli.pminister.R
import com.kfadli.pminister.R.string
import com.kfadli.pminister.response.Seller


fun Seller.formatSellsAndReviews(context: Context): String {
  return if (averageScore == null) {
    context.getString(string.new_seller)
  } else {
    context.getString(R.string.average_seller,
        formatReview(averageScore), saleCount)
  }
}