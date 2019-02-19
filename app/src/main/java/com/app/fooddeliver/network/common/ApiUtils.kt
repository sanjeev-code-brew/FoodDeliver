package com.helpo.network.common

import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import java.io.File

object ApiUtils {
    private fun getErrorMessage(errorJson: String?): String {
        if (errorJson.isNullOrBlank()) {
            return ""
        }

        return try {
            val errorJsonObject = JSONObject(errorJson)
            errorJsonObject.getString("message")
        } catch (exception: Exception) {
            ""
        }
    }

    fun getError(statusCode: Int, errorJson: String?): AppError {
        val message = getErrorMessage(errorJson)
        return if (statusCode == 401) {
            AppError.ApiUnauthorized(message)
        } else {
            AppError.ApiError(statusCode, message)
        }
    }

    fun failure(throwable: Throwable): AppError {
        return AppError.ApiFailure(throwable.localizedMessage ?: "")
    }

    fun imageToRequestBody(imageFile: File): RequestBody =
            RequestBody.create(MediaType.parse("image/*"), imageFile)

    fun imageToRequestBodyKey(parameterName: String, fileName: String): String =
            "$parameterName\"; filename=\"$fileName"
}

fun <T> Response<T>.getAppError(): AppError {
    return ApiUtils.getError(code(), errorBody()?.string())
}