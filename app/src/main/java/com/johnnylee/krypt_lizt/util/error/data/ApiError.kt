package com.johnnylee.krypt_lizt.util.error.data

class ApiError(
    var httpCode: Int,
    var mensagem: String,
    var description: String
)