package edu.istea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import edu.istea.modelo.Paciente
import edu.istea.views.ComidaFragment
import edu.istea.views.PostreFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombrePaciente:EditText = findViewById(R.id.nombre_persona)
        val comidaBoton:Button = findViewById(R.id.comida)
        val postreBoton:Button =findViewById(R.id.postre)

        // mapearnos los frame, que seran replazados por fragmentos

        // hagamos que la aplicacion soporte fragmentos




        // el fragmento se puede inciializar bajo un evento o dee forma directa

        comidaBoton.setOnClickListener(

            View.OnClickListener {
                // inicializamos el fragmento de comida
                val manager = supportFragmentManager
                val transaccion = manager.beginTransaction()

                val p: Paciente = Paciente(nombrePaciente.text.toString(),"Mila Napo con pure","ensalada de papa","flan con dulce",R.mipmap.milanesa)

                // creamos el objeto de la clase que extiende de Fragment()
                val objComidaFragment: ComidaFragment = ComidaFragment()

                // loqica para aplicar y llenar el obj paciente

                // pasarle objetos a un fragmento
                val args = Bundle()

                args.putParcelable("comida",p)

                objComidaFragment.arguments=args
                // reemplazamos el layout de nuestra actividad por la clase q exitende de Fragment
                transaccion.replace(R.id.m_comida_layout,objComidaFragment)

                // ejecutamos la transaccion
                transaccion.commit()

            }
        )


        postreBoton.setOnClickListener(
            View.OnClickListener {
                val manager = supportFragmentManager
                val transaccion = manager.beginTransaction()
                val objPostreFrg: PostreFragment = PostreFragment()
                val args = Bundle()
                val p: Paciente = Paciente(nombrePaciente.text.toString(),"Mila Napo con pure","ensalada de papa","flan con dulce",R.mipmap.flan)

                args.putParcelable("postre",p)
                objPostreFrg.arguments = args
                transaccion.replace(R.id.m_postre_layout,objPostreFrg)
                transaccion.commit()

            }
        )
    }
}