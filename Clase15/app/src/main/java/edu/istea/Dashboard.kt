package edu.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val imagen: ImageView = findViewById(R.id.d_imagen)
        imagen.setImageResource(R.mipmap.intro)
    }
}