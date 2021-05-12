package com.istea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.istea.adapter.HeladoAdapter
import com.istea.modelo.Helado

class MainActivity : AppCompatActivity() {
    val listaHelado: ArrayList<Helado> =ArrayList<Helado>()
    lateinit var rvHelado: RecyclerView
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializoHelados()

        rvHelado=findViewById(R.id.recycleview_helado)

        rvHelado.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        rvHelado.adapter= HeladoAdapter(listaHelado)



    }


    // simulamos que lo cargamos por la base de datos
   private fun inicializoHelados(){
        listaHelado.add(Helado("cono",200,R.mipmap.cono))
        listaHelado.add(Helado("cuarto",400,R.mipmap.cuarto))
        listaHelado.add(Helado("kilo",700,R.mipmap.kilo))

    }
}