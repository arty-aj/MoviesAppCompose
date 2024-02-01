package com.example.moviesappcompose.utils

import com.example.moviesappcompose.models.data.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy{
        Retrofit.Builder()
            .baseUrl(Utils.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}