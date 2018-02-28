package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class AdvertsItem(

    @field:SerializedName("seller")
    val seller: Seller? = null,

    @field:SerializedName("shippingTypes")
    val shippingTypes: List<String?>? = null,

    @field:SerializedName("isPickupAllowed")
    val isPickupAllowed: Boolean? = null,

    @field:SerializedName("images")
    val images: List<ImagesItem?>? = null,

    @field:SerializedName("productId")
    val productId: Int? = null,

    @field:SerializedName("isUnlimitedQuantity")
    val isUnlimitedQuantity: Boolean? = null,

    @field:SerializedName("salePrice")
    val salePrice: Double? = null,

    @field:SerializedName("isAdvertInCircleRange")
    val isAdvertInCircleRange: Boolean? = null,

    @field:SerializedName("rspCoefficient")
    val rspCoefficient: Int? = null,

    @field:SerializedName("expressDeliveryDate")
    val expressDeliveryDate: Long? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("pickupDistance")
    val pickupDistance: Int? = null,

    @field:SerializedName("sellerComment")
    val sellerComment: String? = null,

    @field:SerializedName("advertId")
    val advertId: Long? = null,

    @field:SerializedName("quality")
    val quality: String? = null,

    @field:SerializedName("imagesUrls")
    val imagesUrls: List<String?>? = null,

    @field:SerializedName("isEligibleClickAndCollect")
    val isEligibleClickAndCollect: Boolean? = null,

    @field:SerializedName("shippingAmount")
    val shippingAmount: Double? = null,

    @field:SerializedName("attributes")
    val attributes: Any? = null,

    @field:SerializedName("allowOnlyPickup")
    val allowOnlyPickup: Boolean? = null,

    @field:SerializedName("rspMinimumAmount")
    val rspMinimumAmount: Int? = null,

    @field:SerializedName("availableShippingTypes")
    val availableShippingTypes: List<AvailableShippingTypesItem?>? = null,

    @field:SerializedName("rspCampaignDiscount")
    val rspCampaignDiscount: Double? = null
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readParcelable(Seller::class.java.classLoader),
      parcel.createStringArrayList(),
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.createTypedArrayList(ImagesItem),
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.readValue(Double::class.java.classLoader) as? Double,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readString(),
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readString(),
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readString(),
      parcel.createStringArrayList(),
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.readValue(Double::class.java.classLoader) as? Double,
      null,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.createTypedArrayList(AvailableShippingTypesItem),
      parcel.readValue(Double::class.java.classLoader) as? Double)

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeParcelable(seller, flags)
    parcel.writeStringList(shippingTypes)
    parcel.writeValue(isPickupAllowed)
    parcel.writeTypedList(images)
    parcel.writeValue(productId)
    parcel.writeValue(isUnlimitedQuantity)
    parcel.writeValue(salePrice)
    parcel.writeValue(isAdvertInCircleRange)
    parcel.writeValue(rspCoefficient)
    parcel.writeValue(expressDeliveryDate)
    parcel.writeString(type)
    parcel.writeValue(pickupDistance)
    parcel.writeString(sellerComment)
    parcel.writeValue(advertId)
    parcel.writeString(quality)
    parcel.writeStringList(imagesUrls)
    parcel.writeValue(isEligibleClickAndCollect)
    parcel.writeValue(shippingAmount)
    parcel.writeValue(allowOnlyPickup)
    parcel.writeValue(rspMinimumAmount)
    parcel.writeTypedList(availableShippingTypes)
    parcel.writeValue(rspCampaignDiscount)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<AdvertsItem> {
    override fun createFromParcel(parcel: Parcel): AdvertsItem {
      return AdvertsItem(parcel)
    }

    override fun newArray(size: Int): Array<AdvertsItem?> {
      return arrayOfNulls(size)
    }
  }
}