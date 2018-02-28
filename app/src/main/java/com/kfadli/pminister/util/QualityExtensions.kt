package com.kfadli.pminister.util

import android.content.Context
import com.kfadli.pminister.R
import com.kfadli.pminister.enums.QualityEnum

fun QualityEnum.toString(context: Context): String {

  when (name) {
    QualityEnum.ACCEPTABLE.toString() -> return context.getString(R.string.quality_acceptable)
    QualityEnum.LIKE_NEW.toString() -> return context.getString(R.string.quality_like_new)
    QualityEnum.NEW.toString() -> return context.getString(R.string.quality_new)
    QualityEnum.VERY_GOOD.toString() -> return context.getString(R.string.quality_very_good)
  }

  return ""
}