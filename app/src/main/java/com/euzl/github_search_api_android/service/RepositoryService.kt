package com.euzl.github_search_api_android.service

import android.util.Log
import com.euzl.github_search_api_android.dto.SearchResponse
import com.euzl.github_search_api_android.util.RetrofitCallback
import com.euzl.github_search_api_android.util.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryService {
    /**
     * 리포지토리 검색
     * @param word 검색어
     * @param callback 콜백
     */
    fun getRepositoryList(word: String, callback: RetrofitCallback<SearchResponse>) {
        val request: Call<SearchResponse> = RetrofitUtil.repositoryService.getRepositories(word)
        request.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val code = response.code()

                if (code == 200) {
                    response.body()?.let { callback.onSuccess(code, it)
                        Log.d("성공", "onResponse: $it")}
                } else {
                    callback.onFailure(code)
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                callback.onError(t);
            }
        })
    }
}