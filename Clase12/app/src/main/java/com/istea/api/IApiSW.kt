package com.istea.api

import com.istea.modelo.Personaje
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IApiSW {

    @GET("api/people/{id}")
    fun getPersonajeById(@Path("id") id: Int): Call<Personaje>



}