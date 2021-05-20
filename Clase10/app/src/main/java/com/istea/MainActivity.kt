package com.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.istea.dao.DBHelper
import com.istea.dto.Persona

class MainActivity : AppCompatActivity() {

    lateinit var  nombre: EditText
    lateinit var  apellido:EditText
    lateinit var edad:EditText
    lateinit var guardar:Button
    lateinit var modificar:Button
    lateinit var muestroPersonaLy:LinearLayout
    lateinit var ver:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initizalize()
        val dbHelper= DBHelper(this,null)
        val view = LayoutInflater.from(this).inflate(R.layout.persona_layout,null)

        guardar.setOnClickListener(View.OnClickListener {

            dbHelper.guardarPersona(Persona(nombre.text.toString(),apellido.text.toString(),edad.text.toString().toInt()))
            Toast.makeText(this,"Persona guardada", Toast.LENGTH_LONG).show()
        })


        ver.setOnClickListener(View.OnClickListener {


            val pNombre: EditText = view.findViewById(R.id.p_nombre)
            val pApellido:TextView = view.findViewById(R.id.p_apellido)
            val pEdad:TextView = view.findViewById(R.id.p_edad)

            dbHelper.obtenerPersonas().forEach { item ->
                pNombre.setText(item.nombre)
                pApellido.setText(item.apellido)
                pEdad.setText(item.edad.toString())
            }

            muestroPersonaLy.removeAllViews()
            muestroPersonaLy.addView(view)


        })


        modificar.setOnClickListener(View.OnClickListener {
            val view = LayoutInflater.from(applicationContext).inflate(R.layout.persona_layout,null)
            val pNombre: EditText = view.findViewById(R.id.p_nombre)

            Toast.makeText(applicationContext,pNombre.text,Toast.LENGTH_LONG).show()



            //pNombre.setText("hola mundo")
            //dbHelper.modificarPersonaNombre(pNombre.text.toString())

        })


        val modifco:Button = view.findViewById(R.id.modificarPersona)

        modifco.setOnClickListener(View.OnClickListener {
            val pNombre: EditText = view.findViewById(R.id.p_nombre)

            dbHelper.modificarPersonaNombre(pNombre.text.toString())
            Toast.makeText(it.context,pNombre.text,Toast.LENGTH_LONG).show()

        })
    }

    private fun initizalize(){
        nombre=findViewById(R.id.nombre)
        apellido=findViewById(R.id.apellido)
        edad=findViewById(R.id.edad)
        guardar=findViewById(R.id.guardar)
        modificar=findViewById(R.id.modificar)
        ver=findViewById(R.id.ver)
        muestroPersonaLy=findViewById(R.id.muestroPersonaLy)


    }
}