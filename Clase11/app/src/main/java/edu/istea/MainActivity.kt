package edu.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.facebook.stetho.Stetho
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this);


        val botonFlotante:FloatingActionButton = findViewById(R.id.fb)
        botonFlotante.setImageResource(R.mipmap.gordo)
        botonFlotante.setOnClickListener(
            View.OnClickListener {

                val i: Intent = Intent(this,SettingsActivity::class.java)
                startActivity(i)
            }
        )
    }
}