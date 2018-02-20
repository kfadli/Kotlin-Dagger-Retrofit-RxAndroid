package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResponseList(

	@field:SerializedName("result")
	val result: ResultList? = null,

	@field:SerializedName("webserviceVersion")
	val webserviceVersion: String? = null
)