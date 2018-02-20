package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Result(

	@field:SerializedName("cluster")
	val cluster: Cluster? = null,

	@field:SerializedName("collapseBestPrice")
	val collapseBestPrice: String? = null,

	@field:SerializedName("references")
	val references: References? = null,

	@field:SerializedName("pickupAllowed")
	val pickupAllowed: Boolean? = null,

	@field:SerializedName("advertsCount")
	val advertsCount: Int? = null,

	@field:SerializedName("prdTypeCode")
	val prdTypeCode: Int? = null,

	@field:SerializedName("advertsNewCount")
	val advertsNewCount: Int? = null,

	@field:SerializedName("firstSelectorLabel")
	val firstSelectorLabel: String? = null,

	@field:SerializedName("isMevFormAvailable")
	val isMevFormAvailable: Boolean? = null,

	@field:SerializedName("aisle")
	val aisle: String? = null,

	@field:SerializedName("ownerId")
	val ownerId: Int? = null,

	@field:SerializedName("specifications")
	val specifications: Specifications? = null,

	@field:SerializedName("newBestPriceByCluster")
	val newBestPriceByCluster: String? = null,

	@field:SerializedName("adverts")
	val adverts: List<AdvertsItem?>? = null,

	@field:SerializedName("reviews")
	val reviews: List<ReviewsItem?>? = null,

	@field:SerializedName("productDetailTitle")
	val productDetailTitle: String? = null,

	@field:SerializedName("pickUpSelected")
	val pickUpSelected: Boolean? = null,

	@field:SerializedName("collectibleBestPrice")
	val collectibleBestPrice: Int? = null,

	@field:SerializedName("usedBestPrice")
	val usedBestPrice: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("edito")
	val edito: String? = null,

	@field:SerializedName("isPreOrder")
	val isPreOrder: Boolean? = null,

	@field:SerializedName("summaryAvailableStock")
	val summaryAvailableStock: Boolean? = null,

	@field:SerializedName("rspMinimumAmount")
	val rspMinimumAmount: Int? = null,

	@field:SerializedName("rspCampaignDiscount")
	val rspCampaignDiscount: Int? = null,

	@field:SerializedName("isMemo")
	val isMemo: Boolean? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("summaryNewBestPrice")
	val summaryNewBestPrice: String? = null,

	@field:SerializedName("nbReviews")
	val nbReviews: Int? = null,

	@field:SerializedName("bestOffers")
	val bestOffers: BestOffers? = null,

	@field:SerializedName("summaryNew")
	val summaryNew: Boolean? = null,

	@field:SerializedName("advertsUsedCount")
	val advertsUsedCount: Int? = null,

	@field:SerializedName("newBestPrice")
	val newBestPrice: Double? = null,

	@field:SerializedName("topic")
	val topic: String? = null,

	@field:SerializedName("firstSelectorInternalLabel")
	val firstSelectorInternalLabel: String? = null,

	@field:SerializedName("breadcrumbs")
	val breadcrumbs: List<BreadcrumbsItem?>? = null,

	@field:SerializedName("bestPrice")
	val bestPrice: Int? = null,

	@field:SerializedName("canonicalUrlWithoutDomain")
	val canonicalUrlWithoutDomain: String? = null,

	@field:SerializedName("isAvailable")
	val isAvailable: Boolean? = null,

	@field:SerializedName("urlName")
	val urlName: String? = null,

	@field:SerializedName("reviewsAverageNote")
	val reviewsAverageNote: Double? = null,

	@field:SerializedName("similarCategoriesLink")
	val similarCategoriesLink: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("clusterProducts")
	val clusterProducts: List<ClusterProductsItem?>? = null,

	@field:SerializedName("clusterId")
	val clusterId: Int? = null,

	@field:SerializedName("declinationGroupsFroMFP")
	val declinationGroupsFroMFP: String? = null,

	@field:SerializedName("isManuallySEOExcludedProduct")
	val isManuallySEOExcludedProduct: Boolean? = null,

	@field:SerializedName("priceList")
	val priceList: String? = null,

	@field:SerializedName("contributor")
	val contributor: Contributor? = null,

	@field:SerializedName("isNotModifiedSinceLastCrawl")
	val isNotModifiedSinceLastCrawl: Boolean? = null,

	@field:SerializedName("jsonLabelsForSecondSelector")
	val jsonLabelsForSecondSelector: String? = null,

	@field:SerializedName("categories")
	val categories: List<String?>? = null,

	@field:SerializedName("headline")
	val headline: String? = null,

	@field:SerializedName("blurSimilarCategoriesLink")
	val blurSimilarCategoriesLink: Boolean? = null,

	@field:SerializedName("isDigital")
	val isDigital: Boolean? = null,

	@field:SerializedName("summaryBestPrice")
	val summaryBestPrice: String? = null,

	@field:SerializedName("hasOnlyPickupAdverts")
	val hasOnlyPickupAdverts: Boolean? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: Any? = null,

	@field:SerializedName("productIdsWithSelectorLabel")
	val productIdsWithSelectorLabel: String? = null,

	@field:SerializedName("productScope")
	val productScope: String? = null,

	@field:SerializedName("isChangeDateModified")
	val isChangeDateModified: Boolean? = null,

	@field:SerializedName("imagesUrls")
	val imagesUrls: List<String?>? = null,

	@field:SerializedName("advertsCollectibleCount")
	val advertsCollectibleCount: Int? = null,

	@field:SerializedName("googleRichCards")
	val googleRichCards: GoogleRichCards? = null,

	@field:SerializedName("isAutomaticallySEOExcludedProduct")
	val isAutomaticallySEOExcludedProduct: Boolean? = null,

	@field:SerializedName("hasImages")
	val hasImages: Boolean? = null,

	@field:SerializedName("attributes")
	val attributes: Any? = null,

	@field:SerializedName("usedBestPriceByCluster")
	val usedBestPriceByCluster: String? = null
)