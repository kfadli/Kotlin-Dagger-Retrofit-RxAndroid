package com.kfadli.pminister.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Author(

    @field:SerializedName("firstName")
    val firstName: String? = null,

    @field:SerializedName("userBirthDate")
    val userBirthDate: Int? = null,

    @field:SerializedName("registrationBirthDate")
    val registrationBirthDate: Any? = null,

    @field:SerializedName("sellerActivationDate")
    val sellerActivationDate: Any? = null,

    @field:SerializedName("userFirstAdvertTrackingDate")
    val userFirstAdvertTrackingDate: Any? = null,

    @field:SerializedName("isPreOrderGrant")
    val isPreOrderGrant: Boolean? = null,

    @field:SerializedName("lastLoginDate")
    val lastLoginDate: Any? = null,

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("isUserBuyer")
    val isUserBuyer: Boolean? = null,

    @field:SerializedName("creationDate")
    val creationDate: Any? = null
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readString(),
      parcel.readValue(Int::class.java.classLoader) as? Int,
      null,
      null,
      null,
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      null,
      parcel.readString(),
      parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
      null
      )

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(firstName)
    parcel.writeValue(userBirthDate)
    parcel.writeValue(isPreOrderGrant)
    parcel.writeString(login)
    parcel.writeValue(isUserBuyer)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<Author> {
    override fun createFromParcel(parcel: Parcel): Author {
      return Author(parcel)
    }

    override fun newArray(size: Int): Array<Author?> {
      return arrayOfNulls(size)
    }
  }
}