package com.euzl.github_search_api_android.util

import com.euzl.github_search_api_android.api.RepositoryApi
import com.euzl.github_search_api_android.config.ApplicationClass

class RetrofitUtil {
    companion object {
        val repositoryService: RepositoryApi = ApplicationClass.retrofit.create(RepositoryApi::class.java)
    }
}