package com.istea.clase3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val imagen: ImageView = findViewById(R.id.imageView)

        imagen.setImageResource(R.mipmap.gordo)
    }
}