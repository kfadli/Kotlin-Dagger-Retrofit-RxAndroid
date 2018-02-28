package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Seller(

    @field:SerializedName("sellerActivationDate")
    val sellerActivationDate: Any? = null,

    @field:SerializedName("saleCommitCount")
    val saleCommitCount: Int? = null,

    @field:SerializedName("saleCount")
    val saleCount: Int? = null,

    @field:SerializedName("isMicroCompagny")
    val isMicroCompagny: Boolean? = null,

    @field:SerializedName("lastLoginDate")
    val lastLoginDate: Long? = null,

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("creationDate")
    val creationDate: Long? = null,

    @field:SerializedName("averageScore")
    val averageScore: Double? = null,

    @field:SerializedName("isoCountryId")
    val isoCountryId: Int? = null,

    @field:SerializedName("userBirthDate")
    val userBirthDate: Int? = null,

    @field:SerializedName("registrationBirthDate")
    val registrationBirthDate: Any? = null,

    @field:SerializedName("userFirstAdvertTrackingDate")
    val userFirstAdvertTrackingDate: Any? = null,

    @field:SerializedName("sellerAnswerTime")
    val sellerAnswerTime: Long? = null,

    @field:SerializedName("totalSaleCount")
    val totalSaleCount: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("isPreOrderGrant")
    val isPreOrderGrant: Boolean? = null,

    @field:SerializedName("isUserBuyer")
    val isUserBuyer: Boolean? = null


) : Parcelable {
  constructor(parcel: Parcel) : this(
      null,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readString(),
      parcel.readString(),
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Double::class.java.classLoader) as? Double,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      null,
      null,
      parcel.readValue(Long::class.java.classLoader) as? Long,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Int::class.java.classLoader) as? Int,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(saleCommitCount)
    parcel.writeValue(saleCount)
    parcel.writeValue(isMicroCompagny)
    parcel.writeValue(lastLoginDate)
    parcel.writeString(login)
    parcel.writeString(type)
    parcel.writeValue(creationDate)
    parcel.writeValue(averageScore)
    parcel.writeValue(isoCountryId)
    parcel.writeValue(userBirthDate)
    parcel.writeValue(sellerAnswerTime)
    parcel.writeValue(totalSaleCount)
    parcel.writeValue(id)
    parcel.writeValue(isPreOrderGrant)
    parcel.writeValue(isUserBuyer)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<Seller> {
    override fun createFromParcel(parcel: Parcel): Seller {
      return Seller(parcel)
    }

    override fun newArray(size: Int): Array<Seller?> {
      return arrayOfNulls(size)
    }
  }
}