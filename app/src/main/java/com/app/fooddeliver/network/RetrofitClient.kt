package com.helpo.network

import com.app.fooddeliver.utils.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var api: FoodDeliverApi

    init {
        val retrofit = initRetrofitClient()
        api = retrofit.create(FoodDeliverApi::class.java)
    }

    fun getApi(): FoodDeliverApi = api

    private fun initRetrofitClient(): Retrofit {
        System.setProperty("http.keepAlive", "false")

        val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

        val gson = GsonBuilder()
                .setLenient()
                .create()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
    }
}