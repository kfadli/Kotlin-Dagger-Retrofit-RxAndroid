package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

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
)