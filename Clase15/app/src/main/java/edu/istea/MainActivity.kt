package edu.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.istea.views.LoginFrament
import edu.istea.views.RegsitrarFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // indexamos los fragmentos a nuestro main activity

        val loginFrg: LoginFrament = LoginFrament(this)
        val registerFrg: RegsitrarFragment = RegsitrarFragment(this)
        val registrar: Button = findViewById(R.id.b_registrar)
        val login: Button = findViewById(R.id.b_login)
        // explicarle a la actividad que va a aceptar fragmento con el supportManagerFragment
        val manager = supportFragmentManager

        registrar.setOnClickListener(
                View.OnClickListener {
                    val transaction = manager.beginTransaction()

                    transaction.replace(R.id.userchangeframe, registerFrg)
                    transaction.commit()
                }
        )
        login.setOnClickListener(
                View.OnClickListener {
                    val transaction = manager.beginTransaction()

                    transaction.replace(R.id.userchangeframe, loginFrg)
                    transaction.commit()
                }
        )


    }
}