package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

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
)