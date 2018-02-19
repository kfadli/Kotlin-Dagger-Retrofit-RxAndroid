package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ProductsItem(

	@field:SerializedName("bestPrice")
	val bestPrice: Double? = null,

	@field:SerializedName("urlName")
	val urlName: String? = null,

	@field:SerializedName("reviewsAverageNote")
	val reviewsAverageNote: Double? = null,

	@field:SerializedName("pickupAllowed")
	val pickupAllowed: Boolean? = null,

	@field:SerializedName("advertsCount")
	val advertsCount: Int? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("advertsNewCount")
	val advertsNewCount: Int? = null,

	@field:SerializedName("clusterId")
	val clusterId: Int? = null,

	@field:SerializedName("isMevFormAvailable")
	val isMevFormAvailable: Boolean? = null,

	@field:SerializedName("collectibleBestPrice")
	val collectibleBestPrice: Double? = null,

	@field:SerializedName("isNotModifiedSinceLastCrawl")
	val isNotModifiedSinceLastCrawl: Boolean? = null,

	@field:SerializedName("usedBestPrice")
	val usedBestPrice: Double? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("prdCategory")
	val prdCategory: String? = null,

	@field:SerializedName("isPreOrder")
	val isPreOrder: Boolean? = null,

	@field:SerializedName("headline")
	val headline: String? = null,

	@field:SerializedName("categoryRef")
	val categoryRef: Int? = null,

	@field:SerializedName("rspMinimumAmount")
	val rspMinimumAmount: Int? = null,

	@field:SerializedName("rspCampaignDiscount")
	val rspCampaignDiscount: Double? = null,

	@field:SerializedName("isMemo")
	val isMemo: Boolean? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("isDigital")
	val isDigital: Boolean? = null,

	@field:SerializedName("nbReviews")
	val nbReviews: Int? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: Any? = null,

	@field:SerializedName("advertsUsedCount")
	val advertsUsedCount: Int? = null,

	@field:SerializedName("productScope")
	val productScope: String? = null,

	@field:SerializedName("newBestPrice")
	val newBestPrice: Double? = null,

	@field:SerializedName("imagesUrls")
	val imagesUrls: List<String?>? = null,

	@field:SerializedName("advertsCollectibleCount")
	val advertsCollectibleCount: Int? = null,

	@field:SerializedName("topic")
	val topic: String? = null,

	@field:SerializedName("attributes")
	val attributes: Any? = null
)