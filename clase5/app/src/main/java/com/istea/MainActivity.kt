package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.*
import androidx.core.view.get
import com.istea.modelo.User

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var pass: EditText
    lateinit var email: EditText
    lateinit var tel: EditText
    lateinit var fechaNacimiento: EditText
    lateinit var sexo: RadioGroup
    lateinit var opcion:RadioButton
    lateinit var fuma : Switch
    lateinit var spRol: Spinner
    lateinit var guardar: Button
    lateinit var verLista: Button
    val listaUsuario : ArrayList<User> = ArrayList<User>()
    val roles = arrayOf("admin","editor","blogger")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicilizarElementos()

        guardar.setOnClickListener(View.OnClickListener {

          var user =  cargoDatos()

            Log.i("nombre", user.nombre)
            Log.i("pass", user.pass)
            Log.i("email", user.email)
            Log.i("fechaNacimiento", user.fechaNacimiento)
            Log.i("fuma", user.fumar.toString())
            Log.i("sexo", user.sexo)
            Log.i("rol", user.rol)

            listaUsuario.add(user)
            cleanElements()
            Toast.makeText(this, "USUARIO GUARDADO!", Toast.LENGTH_LONG).show()
        })


        verLista.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MuestroUsuarioActivity::class.java)
            intent.putExtra("listaUsuario",listaUsuario)
            startActivity(intent) // llamamos a la nueva actividad
        })
    }

    private fun cargoDatos():User{
        opcion = findViewById(sexo.checkedRadioButtonId)
        val sexoSeleccionado: String = opcion.text.toString()

        
        return User(name.text.toString(),
            pass.text.toString(),
            email.text.toString(),
            tel.text.toString(),
            fechaNacimiento.text.toString(),
            sexoSeleccionado,
            fuma.isChecked,
            spRol.selectedItem.toString())
    }

    private fun inicilizarElementos(){
        name= findViewById(R.id.e_name)
        pass= findViewById(R.id.e_pass)
        email= findViewById(R.id.e_email)
        tel= findViewById(R.id.e_tel)
        fechaNacimiento= findViewById(R.id.e_fecha_nac)
        sexo= findViewById(R.id.r_sexo)

        fuma = findViewById(R.id.s_fuma)
        spRol= findViewById(R.id.s_rol)
        creoSpinnerLayout()
        guardar= findViewById(R.id.b_guardar)
        verLista=findViewById(R.id.b_lista_usuarios)

    }

    private fun cleanElements(){
        name.setText("")
        pass.setText("")
        email.setText("")
        tel.setText("")
        fechaNacimiento.setText("")
        fuma.isChecked=false

    }


    private fun creoSpinnerLayout(){

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,roles)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spRol.adapter = adapter
    }
}