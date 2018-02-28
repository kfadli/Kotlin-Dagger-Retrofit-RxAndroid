package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ReviewsItem(

    @field:SerializedName("date")
    val date: Long? = null,

    @field:SerializedName("note")
    val note: Int? = null,

    @field:SerializedName("author")
    val author: Author? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readParcelable(Author::class.java.classLoader),
      parcel.readString(),
      parcel.readString())

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(date)
    parcel.writeValue(note)
    parcel.writeParcelable(author, flags)
    parcel.writeString(description)
    parcel.writeString(title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<ReviewsItem> {
    override fun createFromParcel(parcel: Parcel): ReviewsItem {
      return ReviewsItem(parcel)
    }

    override fun newArray(size: Int): Array<ReviewsItem?> {
      return arrayOfNulls(size)
    }
  }
}