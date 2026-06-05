package com.example.tpdesynthseroom.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPharmacie {

    private const val BASE_URL = "https://6a219dd6b1d0aaf32b4fc2af.mockapi.io/api/v1/"

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}