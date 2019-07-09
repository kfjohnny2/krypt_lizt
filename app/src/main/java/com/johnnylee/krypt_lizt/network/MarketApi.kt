package com.johnnylee.krypt_lizt.network

import okhttp3.ResponseBody
import retrofit2.http.GET

interface MarketApi{

    /**
     * Get the list of the markets from the API
     */
    @GET("markets")
    suspend fun getMarkets(): ResponseBody
}