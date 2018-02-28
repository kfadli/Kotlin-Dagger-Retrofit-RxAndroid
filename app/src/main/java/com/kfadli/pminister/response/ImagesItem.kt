package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ImagesItem(

	@field:SerializedName("imagesUrls")
	val imagesUrls: ImagesUrls? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readParcelable(ImagesUrls::class.java.classLoader),
			parcel.readValue(Int::class.java.classLoader) as? Int)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(imagesUrls, flags)
		parcel.writeValue(id)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Creator<ImagesItem> {
		override fun createFromParcel(parcel: Parcel): ImagesItem {
			return ImagesItem(parcel)
		}

		override fun newArray(size: Int): Array<ImagesItem?> {
			return arrayOfNulls(size)
		}
	}
}