package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class BestOffers(

	@field:SerializedName("new")
	val aNew: New? = null,

	@field:SerializedName("used")
	val used: Used? = null
)