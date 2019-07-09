package com.johnnylee.krypt_lizt.network

import com.google.gson.JsonObject
import com.johnnylee.krypt_lizt.base.model.Data
import com.johnnylee.krypt_lizt.model.Market
import retrofit2.Response
import retrofit2.http.GET

interface MarketApi{

    /**
     * Get the list of the markets from the API
     */
    @GET("markets")
    suspend fun getMarkets(): Response<Data>
}