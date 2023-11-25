package com.gcendon.a2doparcial

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServices {
    @GET
    suspend fun getFruit(@Url url: String): Response<MutableList<Fruit>>
}