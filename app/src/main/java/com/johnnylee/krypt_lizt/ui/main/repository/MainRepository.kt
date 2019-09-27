package com.johnnylee.krypt_lizt.ui.main.repository

import com.johnnylee.krypt_lizt.base.model.Data
import com.johnnylee.krypt_lizt.model.Market
import com.johnnylee.krypt_lizt.network.MarketApi
import com.johnnylee.krypt_lizt.util.error.data.ApiError
import com.johnnylee.krypt_lizt.util.error.handler.ErrorHandler
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

open class MainRepository(private val marketApi: MarketApi) {
    open suspend fun getMarkets(): List<Market>? {
        val errorHandler = ErrorHandler()

        try {
            val response: Response<Data> = marketApi.getMarkets()
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                val apiError: ApiError? = errorHandler.parseError(response)
                errorHandler.setErrorInfo(response.code(), apiError?.mensagem)
                throw IOException(errorHandler.toString())
            }
        } catch (ex: UnknownHostException) {
            errorHandler.message = "Problema ao tentar acessar o servidor."
            throw UnknownHostException(errorHandler.toString())
        }

    }
}