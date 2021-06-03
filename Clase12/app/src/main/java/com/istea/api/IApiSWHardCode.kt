package com.istea.api

import com.istea.modelo.Personaje
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IApiSWHardCode {

    // https://swapi.dev/api/people/N
    @GET(".")
    fun getPersonaje() : Call<Personaje>

    // val obj = IApiSWHardCode.create().getPersona() ---> Call<Persona> ---> .suscribe(data => {data.json() }

    companion object{

        // por medio del patron creacional builder , me creo un inicializador llamado create()
        fun create() : IApiSWHardCode{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://swapi.dev/api/people/3/")
                .build()

                return retrofit.create(IApiSWHardCode::class.java)
        }

    }
}