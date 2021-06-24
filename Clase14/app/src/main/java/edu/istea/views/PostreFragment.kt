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

class PostreFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.postre_layout,container,false)


        val nombrePostre: TextView = view.findViewById(R.id.p_poste1)
        val foto:ImageView = view.findViewById(R.id.p_foto_postre)

        val args = arguments

        val p: Paciente= (args?.getParcelable<Paciente>("postre")as Paciente)


        // logica para mostrar los elementos
        nombrePostre.setText(p.postreNombre)
        foto.setImageResource(p.foto)


        return view
    }
}