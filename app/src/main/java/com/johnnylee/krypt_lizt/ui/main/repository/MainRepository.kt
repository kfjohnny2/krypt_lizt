package com.johnnylee.krypt_lizt.ui.main.repository

import com.johnnylee.krypt_lizt.base.model.Data
import com.johnnylee.krypt_lizt.model.Market
import com.johnnylee.krypt_lizt.network.MarketApi
import retrofit2.Response
import javax.inject.Inject

open class MainRepository(val marketApi: MarketApi){
    open suspend fun getMarkets() : List<Market>? {
        val response: Response<Data> = marketApi.getMarkets()
        if(response.isSuccessful){
            return response.body()?.data
        }
        return null
    }
}