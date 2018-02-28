package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ImagesUrls(

    @field:SerializedName("entry")
    val entry: List<EntryItem?>? = null
) : Parcelable {
  constructor(parcel: Parcel) : this(parcel.createTypedArrayList(EntryItem))

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeTypedList(entry)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<ImagesUrls> {
    override fun createFromParcel(parcel: Parcel): ImagesUrls {
      return ImagesUrls(parcel)
    }

    override fun newArray(size: Int): Array<ImagesUrls?> {
      return arrayOfNulls(size)
    }
  }
}