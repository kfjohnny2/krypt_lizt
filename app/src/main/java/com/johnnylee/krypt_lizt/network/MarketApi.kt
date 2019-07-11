package com.johnnylee.krypt_lizt.network

import com.google.gson.JsonObject
import com.johnnylee.krypt_lizt.base.model.Data
import com.johnnylee.krypt_lizt.model.Market
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi{

    /**
     * Get the list of the markets from the API
     */
    @GET("markets")
    suspend fun getMarkets(@Query("limit") limit : Int = 10): Response<Data>
}