package com.kfadli.pminister.util

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat

fun currencyFormat(): NumberFormat = NumberFormat.getCurrencyInstance()
fun formatReview(number: Double): String {

  val df = DecimalFormat("#.#")
  df.roundingMode = RoundingMode.CEILING

  return df.format(number)
}
