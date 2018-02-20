package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AdvertsItem(

	@field:SerializedName("seller")
	val seller: Seller? = null,

	@field:SerializedName("shippingTypes")
	val shippingTypes: List<String?>? = null,

	@field:SerializedName("isPickupAllowed")
	val isPickupAllowed: Boolean? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("productId")
	val productId: Int? = null,

	@field:SerializedName("isUnlimitedQuantity")
	val isUnlimitedQuantity: Boolean? = null,

	@field:SerializedName("salePrice")
	val salePrice: Int? = null,

	@field:SerializedName("isAdvertInCircleRange")
	val isAdvertInCircleRange: Boolean? = null,

	@field:SerializedName("rspCoefficient")
	val rspCoefficient: Int? = null,

	@field:SerializedName("expressDeliveryDate")
	val expressDeliveryDate: Long? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("pickupDistance")
	val pickupDistance: Int? = null,

	@field:SerializedName("sellerComment")
	val sellerComment: String? = null,

	@field:SerializedName("advertId")
	val advertId: Long? = null,

	@field:SerializedName("quality")
	val quality: String? = null,

	@field:SerializedName("imagesUrls")
	val imagesUrls: List<String?>? = null,

	@field:SerializedName("isEligibleClickAndCollect")
	val isEligibleClickAndCollect: Boolean? = null,

	@field:SerializedName("shippingAmount")
	val shippingAmount: Double? = null,

	@field:SerializedName("attributes")
	val attributes: Any? = null,

	@field:SerializedName("allowOnlyPickup")
	val allowOnlyPickup: Boolean? = null,

	@field:SerializedName("rspMinimumAmount")
	val rspMinimumAmount: Int? = null,

	@field:SerializedName("availableShippingTypes")
	val availableShippingTypes: List<AvailableShippingTypesItem?>? = null,

	@field:SerializedName("rspCampaignDiscount")
	val rspCampaignDiscount: Double? = null
)