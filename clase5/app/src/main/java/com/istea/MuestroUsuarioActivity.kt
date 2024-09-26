package com.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.istea.modelo.User
import org.w3c.dom.Text
import java.lang.Exception

class MuestroUsuarioActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muestro_usuario)

        val id:EditText = findViewById(R.id.mu_id)
        val buscar :Button=findViewById(R.id.mu_buscar)
        val nombre : TextView = findViewById(R.id.mu_nombre)
        val email : TextView = findViewById(R.id.mu_email)
        val sexo : TextView = findViewById(R.id.mu_sexo)
        val rol : TextView=findViewById(R.id.mu_roi)

        buscar.setOnClickListener(View.OnClickListener {
            try {
                val listaUsuario: ArrayList<User> =  intent.getSerializableExtra("listaUsuario") as ArrayList<User>
                // obtengo un elemento de la lista que recibo
                val user : User =  listaUsuario.get(id.text.toString().toInt())

                nombre.setText("Nombre: " +  user.nombre)
                email.setText("Email: " +user.email)
                sexo.setText("Sexo: " + user.sexo)
                rol.setText("ROL: " + user.rol)
            }catch (e:Exception){
                Toast.makeText(this, "El id no existe o la lista no posee elementos",Toast.LENGTH_SHORT).show()
            }



        })

    }
}