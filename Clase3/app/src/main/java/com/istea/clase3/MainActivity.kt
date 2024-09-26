package com.istea.clase3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.istea.clase3.model.User
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    // creo los elementros y los enlazo en un procedimiento

    lateinit var user: EditText
    lateinit var password:EditText
    lateinit var login:Button
    lateinit var registrar: Button
    lateinit var error:TextView
    // harcode el usuario
    //var usuarioObj = User("admin","admin")

    lateinit var usuarioObj:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarElementos()

        login.setOnClickListener(View.OnClickListener {
            if(validarUsuario(user.text.toString(),password.text.toString())){
                // invocar a la actividad de del gordito de las historietas
                gotToActivity(this,InicioActivity::class.java)
            }else{
                // no tiene acceso se tiene que regsitrar
                error.text="usuario o contraseña invialidad, vuelva a chequear!"
               Toast.makeText(this,"Usuario o contraseña invialidad",Toast.LENGTH_LONG).show()
            }
        })

        registrar.setOnClickListener(
            View.OnClickListener {
                gotToActivity(this,Registrar::class.java)
            }
        )

    }


    fun <T>gotToActivity(context: Context, actividadPorIr:Class<T>){
        val intent: Intent = Intent(context,actividadPorIr)
        startActivity(intent)
    }


    fun validarUsuario(user: String, password:String): Boolean{
        return(usuarioObj.usuario.equals(user)&& usuarioObj.password.equals(password))
    }


    fun inicializarElementos(){
        user = findViewById(R.id.e_user)
        password=findViewById(R.id.e_password)
        login=findViewById(R.id.b_login)
        registrar=findViewById(R.id.b_registrar)
        error=findViewById(R.id.t_error)
        try {
            usuarioObj = intent.getSerializableExtra("objUsuario") as User // recibimos el objeto inicializado de la actividad de Registro
        }catch (e:Exception){
            Log.e("error","el objeto vino vacio")
            usuarioObj = User("admin","admin")
            Log.i("info","usamos el usuario harcode")
        }

    }
}