package edu.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Firebase.messaging.isAutoInitEnabled = true

        val token:EditText = findViewById(R.id.id_token)


        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if(!task.isSuccessful){
                    Toast.makeText(this,"No se pudo conectar al servicio de firebase",Toast.LENGTH_LONG).show()
                }

                token.setText(task.result)
            }
        )

    }
}