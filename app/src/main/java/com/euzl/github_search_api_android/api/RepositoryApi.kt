package com.euzl.github_search_api_android.api

import com.euzl.github_search_api_android.dto.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryApi {
    @GET("search/repositories")
    fun getRepositories(@Query("q") searchWord: String): Call<SearchResponse>
}