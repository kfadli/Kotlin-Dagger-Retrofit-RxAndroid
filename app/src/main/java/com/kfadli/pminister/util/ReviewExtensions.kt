package com.kfadli.pminister.util

import kotlin.math.round

fun roundReview(review: Double): Double {

  var rounded = round(review)

  val delta = (rounded - review)

  if (delta > 0.25 && delta < 0.75) {
    rounded -= 0.5
  } else if (-delta > 0.25 && delta < 0.75) {
    rounded += 0.5
  }

  return rounded
}