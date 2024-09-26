package edu.istea.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.istea.R
import edu.istea.modelo.Paciente

class ComidaFragment : Fragment() {


    // voy a mapear a mi fragmento contra el layout de comida

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.comida_layout, container,false)


        val comida1:TextView = view.findViewById(R.id.c_comida1)
        val comida2: TextView = view.findViewById(R.id.c_comida2)
        val foto:ImageView = view.findViewById(R.id.c_foto_comida)

        // de alguna manera vamos a estar recibiendo parametros


        val args = arguments

         val p: Paciente =  (args?.getParcelable<Paciente>("comida") as Paciente)

        comida1.setText(p.comida1)
        comida2.setText(p.comida2)
        foto.setImageResource(p.foto)

        return view
    }
}