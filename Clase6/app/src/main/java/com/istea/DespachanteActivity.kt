package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class DespachanteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despachante)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_heladeria,menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menu_home->{
                startActivity(Intent(this,MainActivity::class.java))

                true
            }
            R.id.menu_desp->{
                Toast.makeText(this,"Estas parado en la actividad de despachante ", Toast.LENGTH_SHORT).show()

                true
            }
            else->{
                true
            }
        }
    }
}