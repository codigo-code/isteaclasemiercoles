package edu.istea.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.istea.R
import edu.istea.dao.DBHelper
import edu.istea.model.User

class RegsitrarFragment(val contextMain:Context) : Fragment() {

    // lo mismo para el resgistrar es cuasi un copy paste
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.registar_layout, container, false)

        val user: EditText = view.findViewById(R.id.r_user)
        val pass: EditText = view.findViewById(R.id.r_pass)
        val register: Button = view.findViewById(R.id.r_saveuser)

        val db: DBHelper = DBHelper(contextMain,null)

        register.setOnClickListener(
            View.OnClickListener {
                db.saveUser(User(user.text.toString(),pass.text.toString()))
                Toast.makeText(view.context,"guardo el usuario",Toast.LENGTH_LONG).show()
            }
        )


        return view
    }

}