package com.example.chucknorrisfacts

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RestClient {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(OkHttpClient()).build()
    }

    fun getFactsService(): IFactsService = retrofit.create(IFactsService::class.java)
}