package com.example.postmotivation.dataclass

import com.google.gson.annotations.SerializedName

data class Page (
    val page: Long,
    @SerializedName("per_page")
    val perPage: Long,
    val photos: List<Photo>,
    @SerializedName("next_page")
    val nextPage: String
)

data class Photo (
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

    val src: Photos,
    val liked: Boolean
)

data class Photos (
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

