package com.test.apps.myapplication.network

import com.test.apps.myapplication.model.ResponseJsonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimDataInterface {

    @GET("anime?")
    suspend fun getAnimData(
        @Query("q") q: String
    ): ResponseJsonData.resultJsonData

    @GET("anime?")
    suspend fun getAnimDataWithStatusCode(
        @Query("q") q: String
    ): Call<ResponseJsonData.resultJsonData>

}