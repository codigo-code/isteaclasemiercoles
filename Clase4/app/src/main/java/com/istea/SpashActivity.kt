package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpashActivity : AppCompatActivity() {

    private val TIME_OUT:Long=5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)
        cargarPantalla()
    }

    private fun cargarPantalla(){
        // thread.sleep(5000)  ---> 5 seg
        Handler().postDelayed({ // simulando que cargamos servicios recursos etc
            // va a espera
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish() // mata la actividad --> la destruye

        },TIME_OUT) // <-- va a dejar pasar 5 sec para ejecutar el bloque del postDeplayed
    }
}