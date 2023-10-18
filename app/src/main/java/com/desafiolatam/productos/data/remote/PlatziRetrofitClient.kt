package com.desafiolatam.productos.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlatziRetrofitClient {
    companion object {
        private const val BASE_URL = "https://api.escuelajs.co/api/v1/"

        fun retrofitInstance(): PlatziRetrofitApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(PlatziRetrofitApi::class.java)
        }
    }
}