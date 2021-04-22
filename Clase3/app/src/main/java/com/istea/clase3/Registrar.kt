package com.istea.clase3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.istea.clase3.model.User

class Registrar : AppCompatActivity() {

    lateinit var user: EditText
    lateinit var pass:EditText
    lateinit var repass:EditText
    lateinit var registrar:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        initCompontent()

        registrar.setOnClickListener(
            View.OnClickListener {
                if(pass.text.toString().equals(repass.text.toString())){
                    // registrar usuario
                    val userObj: User=User(user.text.toString(),pass.text.toString())
                    val intento : Intent = Intent(this,MainActivity::class.java)
                    intento.putExtra("objUsuario",userObj)
                    startActivity(intento)
                }else{
                    Toast.makeText(this,"Error en las contraseñas!",Toast.LENGTH_LONG).show()
                }
            }
        )
    }


    fun initCompontent(){
        user=findViewById(R.id.r_e_usuario)
        pass=findViewById(R.id.r_e_password)
        repass=findViewById(R.id.r_e_repassword)
        registrar=findViewById(R.id.r_b_registrar)

    }


}