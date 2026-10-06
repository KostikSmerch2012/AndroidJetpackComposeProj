package com.example.data.repository.remote

import retrofit2.Retrofit

object RetrofitClient {

    private const val BASE_URL = "https://recipe.product-solutions.ru/api/v1"

    private val retrofitBuilder = Retrofit.Builder().baseUrl(BASE_URL).build()

    val retrofitService : ApiService by lazy {
        retrofitBuilder.create(ApiService::class.java)
    }
}