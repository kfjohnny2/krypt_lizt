package com.johnnylee.krypt_lizt.util.error.handler

import com.johnnylee.krypt_lizt.util.error.data.ApiError
import com.johnnylee.krypt_lizt.util.error.data.OAuthError
import org.json.JSONObject
import retrofit2.Response

class ErrorHandler {

    var message: String? = null
    var status: String? = null

    fun parseError(response: Response<*>): ApiError {
        val errorBody = response.errorBody()!!.string()
        val bodyObj = JSONObject(errorBody)

        val httpCode = bodyObj.getInt("httpCode")
        val mensagem = bodyObj.getString("mensagem")
        val description = bodyObj.getString("description")

        return ApiError(httpCode, mensagem, description)
    }

    fun parseOAuthError(response: Response<*>?): OAuthError? {
        return if (response != null) {
            val errorBody = response.errorBody()!!.string()
            val bodyObj = JSONObject(errorBody)
            val error = bodyObj.getString("error")
            val description = bodyObj.getString("error_description")

            OAuthError(error, description)
        } else null
    }

    fun setErrorInfo(code: Int?, status: String?) {
        if (code == 400 || code == 403) {
            this.message = "Problema ao tentar acessar o servidor."
            this.status = status
        } else if (code in 500..599) {
            this.message =
                "Lamentamos o ocorrido, mas pelo visto estamos com problemas em nosso sistema. Tente novamente em breve."
            this.status = status
        } else if (code == 401) {
            this.message = "Seu acesso expirou!"
            this.status = status

        } else {
            this.message =
                "Pelo visto o aplicativo se comportou de maneira inexperada. Por favor, tente novamente."
        }
    }

    override fun toString(): String {
        status?.let { return "$status $message" }
        return "$message"
    }
}