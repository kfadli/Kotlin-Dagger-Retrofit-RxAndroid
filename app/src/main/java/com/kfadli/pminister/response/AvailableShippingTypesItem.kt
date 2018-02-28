package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class AvailableShippingTypesItem(

	@field:SerializedName("isUnsupportedWithFreeShipping")
	val isUnsupportedWithFreeShipping: Boolean? = null,

	@field:SerializedName("canBeModified")
	val canBeModified: Boolean? = null,

	@field:SerializedName("isPreselectedByDefault")
	val isPreselectedByDefault: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("isAllowedForSeller")
	val isAllowedForSeller: Boolean? = null,

	@field:SerializedName("isAllowedByPlatform")
	val isAllowedByPlatform: Boolean? = null,

	@field:SerializedName("isMandatoryForFreeShipping")
	val isMandatoryForFreeShipping: Boolean? = null,

	@field:SerializedName("isMandatory")
	val isMandatory: Boolean? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString(),
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
			parcel.readValue(Boolean::class.java.classLoader) as? Boolean) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(isUnsupportedWithFreeShipping)
		parcel.writeValue(canBeModified)
		parcel.writeValue(isPreselectedByDefault)
		parcel.writeValue(id)
		parcel.writeString(label)
		parcel.writeValue(isAllowedForSeller)
		parcel.writeValue(isAllowedByPlatform)
		parcel.writeValue(isMandatoryForFreeShipping)
		parcel.writeValue(isMandatory)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Creator<AvailableShippingTypesItem> {
		override fun createFromParcel(parcel: Parcel): AvailableShippingTypesItem {
			return AvailableShippingTypesItem(parcel)
		}

		override fun newArray(size: Int): Array<AvailableShippingTypesItem?> {
			return arrayOfNulls(size)
		}
	}
}