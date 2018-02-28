package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class EntryItem(

    @field:SerializedName("size")
    val size: String? = null,

    @field:SerializedName("url")
    val url: String? = null
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readString(),
      parcel.readString())

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(size)
    parcel.writeString(url)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<EntryItem> {
    override fun createFromParcel(parcel: Parcel): EntryItem {
      return EntryItem(parcel)
    }

    override fun newArray(size: Int): Array<EntryItem?> {
      return arrayOfNulls(size)
    }
  }
}