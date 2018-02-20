package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ClusterProductsItem(

	@field:SerializedName("bestPrice")
	val bestPrice: Int? = null,

	@field:SerializedName("isMemo")
	val isMemo: Boolean? = null,

	@field:SerializedName("isDigital")
	val isDigital: Boolean? = null,

	@field:SerializedName("nbReviews")
	val nbReviews: Int? = null,

	@field:SerializedName("reviewsAverageNote")
	val reviewsAverageNote: Int? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: Any? = null,

	@field:SerializedName("pickupAllowed")
	val pickupAllowed: Boolean? = null,

	@field:SerializedName("advertsCount")
	val advertsCount: Int? = null,

	@field:SerializedName("advertsNewCount")
	val advertsNewCount: Int? = null,

	@field:SerializedName("isMevFormAvailable")
	val isMevFormAvailable: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("advertsUsedCount")
	val advertsUsedCount: Int? = null,

	@field:SerializedName("newBestPrice")
	val newBestPrice: Double? = null,

	@field:SerializedName("imagesUrls")
	val imagesUrls: List<String?>? = null,

	@field:SerializedName("collectibleBestPrice")
	val collectibleBestPrice: Int? = null,

	@field:SerializedName("advertsCollectibleCount")
	val advertsCollectibleCount: Int? = null,

	@field:SerializedName("isNotModifiedSinceLastCrawl")
	val isNotModifiedSinceLastCrawl: Boolean? = null,

	@field:SerializedName("usedBestPrice")
	val usedBestPrice: Double? = null,

	@field:SerializedName("attributes")
	val attributes: Any? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("isPreOrder")
	val isPreOrder: Boolean? = null
)