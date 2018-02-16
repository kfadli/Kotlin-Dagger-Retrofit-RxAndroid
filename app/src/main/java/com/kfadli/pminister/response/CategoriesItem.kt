package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class CategoriesItem(

	@field:SerializedName("isBlurred")
	val isBlurred: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("productsCount")
	val productsCount: Int? = null
)