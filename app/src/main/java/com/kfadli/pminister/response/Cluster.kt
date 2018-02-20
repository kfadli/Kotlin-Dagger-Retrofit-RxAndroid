package com.kfadli.pminister.response

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Cluster(

	@field:SerializedName("urlName")
	val urlName: String? = null,

	@field:SerializedName("clusterInfoDto")
	val clusterInfoDto: ClusterInfoDto? = null,

	@field:SerializedName("attributes")
	val attributes: Any? = null,

	@field:SerializedName("clusterId")
	val clusterId: Int? = null
)