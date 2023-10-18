package com.desafiolatam.productos.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface PlatziRetrofitApi {

    @GET("assets")
    suspend fun getData(): Response<Data>
}
