package com.example.postmotivation.dataclass

import com.google.gson.annotations.SerializedName

data class Pagination (
    @SerializedName("total_results")
    val totalResults: Long,
    val page: Long,
    @SerializedName("per_page")
    val perPage: Long,
    val photos: List<Phot>,
    @SerializedName("next_page")
    val nextPage: String
)

data class Phot (
    val id: Long,
    val width: Long,
    val height: Long,
    val url: String,
    val photographer: String,
    @SerializedName("photographer_url")
    val photographerURL: String,
    @SerializedName("photographer_id")
    val photographerID: Long,
    @SerializedName("avg_color")
    val avgColor: String,
    val src: Src,
    val liked: Boolean
)

data class Src (
    val original: String,
    @SerializedName("large2x")
    val large2X: String,
    val large: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String
)
