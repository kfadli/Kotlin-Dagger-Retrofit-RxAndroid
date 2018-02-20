package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class JsonMemberNew(

	@field:SerializedName("adverts")
	val adverts: List<AdvertsItem?>? = null,

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("isBuybox")
	val isBuybox: Boolean? = null
)