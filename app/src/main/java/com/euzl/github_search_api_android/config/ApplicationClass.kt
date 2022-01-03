package com.euzl.github_search_api_android.config

import android.app.Application
import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    companion object {
        const val BASE_URL = "https://api.github.com/"

        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        // OkHttp 클라이언트 생성
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        // 앱이 처음 생성될 때, retrofit 인스턴스 생성
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}