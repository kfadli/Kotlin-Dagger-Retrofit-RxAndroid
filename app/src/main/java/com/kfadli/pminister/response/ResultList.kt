package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultList(

    @field:SerializedName("resultProductsCount")
    val resultProductsCount: Int? = null,

    @field:SerializedName("hasUsedProducts")
    val hasUsedProducts: Boolean? = null,

    @field:SerializedName("canonicalUrlWithoutDomain")
    val canonicalUrlWithoutDomain: String? = null,

    @field:SerializedName("selectedFilters")
    val selectedFilters: List<Any?>? = null,

    @field:SerializedName("navIsWhitelisted")
    val navIsWhitelisted: Boolean? = null,

    @field:SerializedName("isHomeUniverse")
    val isHomeUniverse: Boolean? = null,

    @field:SerializedName("isOnlyFreeShippingSelected")
    val isOnlyFreeShippingSelected: Boolean? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("metaDescription")
    val metaDescription: String? = null,

    @field:SerializedName("products")
    val products: List<ProductsItem?>? = null,

    @field:SerializedName("sortTypeIndex")
    val sortTypeIndex: Int? = null,

    @field:SerializedName("isKeywordWhiteListed")
    val isKeywordWhiteListed: Boolean? = null,

    @field:SerializedName("isUnitFilterOpeningActivated")
    val isUnitFilterOpeningActivated: Boolean? = null,

    @field:SerializedName("isOnlyExpressDeliverySelected")
    val isOnlyExpressDeliverySelected: Boolean? = null,

    @field:SerializedName("isElasticSearchResult")
    val isElasticSearchResult: Boolean? = null,

    @field:SerializedName("categories")
    val categories: List<CategoriesItem?>? = null,

    @field:SerializedName("keyword")
    val keyword: String? = null,

    @field:SerializedName("suggestedAlternativeResults")
    val suggestedAlternativeResults: Any? = null,

    @field:SerializedName("hasNewProducts")
    val hasNewProducts: Boolean? = null,

    @field:SerializedName("totalResultProductsCount")
    val totalResultProductsCount: Int? = null,

    @field:SerializedName("filterShippingTypes")
    val filterShippingTypes: List<FilterShippingTypesItem?>? = null,

    @field:SerializedName("blurPaginationAccordingToCategoryAndFilters")
    val blurPaginationAccordingToCategoryAndFilters: Boolean? = null,

    @field:SerializedName("filters")
    val filters: List<Any?>? = null,

    @field:SerializedName("isPaginationConfBlur")
    val isPaginationConfBlur: Boolean? = null,

    @field:SerializedName("metaTitle")
    val metaTitle: String? = null,

    @field:SerializedName("sortsType")
    val sortsType: List<SortsTypeItem?>? = null
)