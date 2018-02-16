package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Response(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("webserviceVersion")
	val webserviceVersion: String? = null
)