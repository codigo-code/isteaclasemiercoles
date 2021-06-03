package com.istea.api.implementation

import com.istea.api.IApiSW
import com.istea.modelo.Personaje
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiSW{

    // generar la vinculacion entre retrofit y el endpoint
    // endpoint = url API
    private fun getRetrofit() :Retrofit{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://swapi.dev/")
            .build()
    }

    // invocamos al interfaz que tiene la invocacion al endpoint
    fun getPersonajeById(id: Int):Call<Personaje>{
        return getRetrofit().create(IApiSW::class.java).getPersonajeById(id)
    }
}