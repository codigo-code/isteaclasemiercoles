package edu.istea.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.istea.Dashboard
import edu.istea.R
import edu.istea.dao.DBHelper
import edu.istea.model.User

class LoginFrament(val contextMain: Context) :Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_layout,container,false)


        // esto sigue pero bueno..., comparto y sigo programando... no los oigo :( tiipeen en el chat...

        // lo malo es q me sali de la de windows... si se cuelga sone... pero voy chequeando...


        // lo que toca hacer es ligar el layout login al fragmentos con los elementos


        // 2 edit text y 1 boton
        // el fiindById es de view .... porque lo acablo de obtener cuando infle la vista
        val user:EditText = view.findViewById(R.id.l_user)
        val pass:EditText = view.findViewById(R.id.l_pass)
        val login:Button = view.findViewById(R.id.l_login)

        val db: DBHelper = DBHelper(contextMain,null)

        login.setOnClickListener(
            View.OnClickListener {
                if(db.validateUser(User(user.text.toString(),pass.text.toString()))){
                    // TODO: ir al dashboard de usuarios
                    val intent: Intent= Intent(view.context, Dashboard::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(view.context,"Usuario no encontrado, REGISTRESE", Toast.LENGTH_LONG).show()
                }

            }
        )


        return view
    }
}