package com.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.istea.api.IApiSWHardCode
import com.istea.api.implementation.ApiSW
import com.istea.modelo.Personaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var  name: TextView
    lateinit var  mass: TextView
    lateinit var  height: TextView
    lateinit var  skin_color: TextView
    lateinit var  hair_color: TextView
    lateinit var  gener: TextView
    lateinit var  eye_color: TextView
    lateinit var  birth_year: TextView
    lateinit var  homeworld: TextView
    lateinit var idPersonaje: EditText
    lateinit var buscar:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        // invocar a nuestra api para que nos traiga los elementos

        //val apiHC = IApiSWHardCode.create().getPersonaje()

        // invoco a la clase que contiene el api
        val api: ApiSW = ApiSW()


        buscar.setOnClickListener(View.OnClickListener {

          // get --->
            api.getPersonajeById(idPersonaje.text.toString().toInt()).enqueue(object: Callback<Personaje>{

                override fun onFailure(call: Call<Personaje>, t: Throwable) {
                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Personaje>, response: Response<Personaje>) {

                    if(response.body() != null){
                        val data = response.body()

                        name.text=data?.name
                        mass.text=data?.mass
                        height.text=data?.height
                        skin_color.text=data?.skin_color
                        hair_color.text=data?.hair_color
                        gener.text=data?.gender
                        birth_year.text=data?.birth_year
                        eye_color.text=data?.eye_color
                        homeworld.text=data?.homeworld
                    }

                }

            })

        })




    }


    private fun initialize(){
        name = findViewById(R.id.name)
        mass = findViewById(R.id.mass)
        height = findViewById(R.id.height)
        eye_color = findViewById(R.id.eye_color)
        hair_color = findViewById(R.id.hair_color)
        skin_color = findViewById(R.id.skin_color)
        gener = findViewById(R.id.gener)
        birth_year = findViewById(R.id.birth_year)
        homeworld = findViewById(R.id.homeworld)
        idPersonaje=findViewById(R.id.idPersonaje)
        buscar= findViewById(R.id.buscar)
    }
}