package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ReviewsItem(

	@field:SerializedName("date")
	val date: Long? = null,

	@field:SerializedName("note")
	val note: Int? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)