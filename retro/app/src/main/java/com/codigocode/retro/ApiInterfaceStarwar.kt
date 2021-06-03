package com.codigocode.retro

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterfaceStarwar {

    @GET(".")
    fun getPj(): Call<Start>

    companion object{

        fun create():ApiInterfaceStarwar{
            val retro = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://swapi.dev/api/people/1/")
                .build();

            return retro.create(ApiInterfaceStarwar::class.java)
        }

    }
}