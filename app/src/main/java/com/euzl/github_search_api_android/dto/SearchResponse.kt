package com.euzl.github_search_api_android.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class SearchResponse (
    @SerializedName("total_count")
    val totalCount: Int,

    @SerializedName("items")
    val items: List<RepositoryDto>? = null
)