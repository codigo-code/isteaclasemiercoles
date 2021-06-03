package com.codigocode.retro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


try {

    var api = ApiInterfaceStarwar.create().getPj()

    api.enqueue(object  : Callback<Start> {
        override fun onFailure(call: Call<Start>, t: Throwable) {
            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()

        }

        override fun onResponse(call: Call<Start>, response: Response<Start>) {

            if(response?.body() != null){
                Toast.makeText(applicationContext, response.body()!!.name, Toast.LENGTH_LONG).show()
            }
        }

    })



}catch ( e : Exception){
    Log.e("error", e.message,e)
}

    }
}