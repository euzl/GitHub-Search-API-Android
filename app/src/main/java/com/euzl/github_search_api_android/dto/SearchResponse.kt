package com.euzl.github_search_api_android.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class SearchResponse (
    @SerializedName("total_count")
    val totalCount: Int,

    @SerializedName("items")
    val items: List<RepositoryDto>? = null
) {
    data class RepositoryDto(
        @SerializedName("id")
        val id: Int,

        @SerializedName("full_name")
        val fullName: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("stargazers_count")
        val starCount: Int,

        @SerializedName("language")
        val language: String,

        @SerializedName("license")
        val license: String,

        @SerializedName("updated_at")
        val updatedAt: Date
    )
}