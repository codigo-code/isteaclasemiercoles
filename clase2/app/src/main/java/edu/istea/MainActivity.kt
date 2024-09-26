package edu.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // enlazo el elemento con mi actividad

        val altura : EditText = findViewById(R.id.altura)
        val peso : EditText = findViewById(R.id.peso)
        val calcular: Button= findViewById(R.id.calcular)
        val foto :ImageView=findViewById(R.id.foto)


        calcular.setOnClickListener(View.OnClickListener {
            // creo una variable al => que le asigno el valor de la caja de texto numerico
            val al = altura.text.toString().toDouble()

            val res = (peso.text.toString().toDouble() / (al* al))

            if( res < 18.5){
                foto.setImageResource(R.mipmap.flaco)
            } else if(res >= 18.5 && res <= 24.9){
                foto.setImageResource(R.mipmap.normal)
            }else{
                foto.setImageResource(R.mipmap.gordo)
            }


        })
    }
}