package com.test.apps.myapplication.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class NetworkManager {
    companion object {
        private val TIMEOUT: Long = 60

        //        private const val URL_BASE = "https://api.jikan.moe/v3/search/anime?q=naruto"
        private const val URL_BASE = "https://api.jikan.moe/v3/search/"

        private val OK_HTTP = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }


    suspend fun requestData(): AnimDataInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OK_HTTP)
            .build()

        var resultData: AnimDataInterface = retrofit.create(AnimDataInterface::class.java)
        return resultData
    }


}