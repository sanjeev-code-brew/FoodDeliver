package com.helpo.network.common

sealed class AppError {
    data class ApiError(val statusCode: Int, val msg: String) : AppError()
    data class ApiUnauthorized(val msg: String) : AppError()
    data class ApiFailure(val msg: String) : AppError()

}