package com.helpo.network.common

data class ApiResponse<out T>(
        val msg: String? = null,
        val data: T? = null)