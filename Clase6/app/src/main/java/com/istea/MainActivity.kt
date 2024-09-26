package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var bCaja1:Button
    lateinit var bCaja2:Button
    lateinit var pedido:EditText
    lateinit var muestroPedidoLayout:LinearLayout
    lateinit var bMostrar:Button
    lateinit var rbGustos:RadioGroup
    lateinit var opcion:RadioButton
    lateinit var bMostrarHelado:Button
    var contadorPedidoCaja1:Int=0

    val lista:ArrayList<String> = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bCaja1= findViewById(R.id.b_caja1)
        bCaja2=findViewById(R.id.b_caja2)
        pedido=findViewById(R.id.e_pedido)
        muestroPedidoLayout=findViewById(R.id.muestroPeididoLayout)
        bMostrar=findViewById(R.id.bmostrar)
        bMostrarHelado=findViewById(R.id.b_verHelado)
        rbGustos=findViewById(R.id.rg_tipo_helado)
        bCaja1.setOnClickListener(View.OnClickListener {
            if(contadorPedidoCaja1 <3 ){
                lista.add("caja1 - " + pedido.text.toString())
                Toast.makeText(this,"pedido agregado caja 1 ", Toast.LENGTH_SHORT).show()
                pedido.setText("")
                contadorPedidoCaja1++

            }else{
                Toast.makeText(this,"llegaste al limite papu",Toast.LENGTH_SHORT).show()
                bCaja1.isEnabled=false
            }
        })
        bCaja2.setOnClickListener(View.OnClickListener {
            lista.add("caja2 - " + pedido.text.toString())
            Toast.makeText(this,"pedido agregado caja 2 ", Toast.LENGTH_SHORT).show()
        pedido.setText("")
        })

        bMostrar.setOnClickListener(View.OnClickListener {
            var view = LayoutInflater.from(this).inflate(R.layout.muestro_pedido_layout,null)
            // nos estamos trayendo el layout de forma dinamica y podemos utilizar los elementos

           val muestroPedidosText: TextView =  view.findViewById(R.id.mpPedido)

            lista.forEach{
                if(it.toString().contains("caja1"))
                    muestroPedidosText.text = muestroPedidosText.text.toString() + it + "\n"
            }

            // agrego de forma dinamica una vista a mi linearLayout
            muestroPedidoLayout.removeAllViews()
            muestroPedidoLayout.addView(view)

        })

        // cuando seleccion la opcion en el radioGroup mostrara
        // inflando un nuevo layout dentro del linearLayout llamado muestroPeididoLayout
        // de forma dinamica traemos el layout llamado -> muestro_helado.xml
        bMostrarHelado.setOnClickListener(View.OnClickListener {

            // invocamos al layout mostrar_helado -> en la constrante view
            val view = LayoutInflater.from(this).inflate(R.layout.muestro_helado,null)
            // parados en la vista ( layout muestro_helado)
            // mapeo los elementos foto y descripcion
            val foto:ImageView = view.findViewById(R.id.mh_foto)
            val descripcion:TextView=view.findViewById(R.id.mh_descripcion)
            // comportamiento para la vista muestro_helado

            opcion= findViewById(rbGustos.checkedRadioButtonId)

            // switch --> c#

            when(opcion.text.toString().toLowerCase()){
                "cono"->{
                    foto.setImageResource(R.mipmap.cono)
                    descripcion.setText("Cono de dos gustos")
                }
                "kilo"->{
                    foto.setImageResource(R.mipmap.kilo)
                    descripcion.setText("kilo de 4 gustos")
                }
                "cuarto"->{
                    foto.setImageResource(R.mipmap.cuarto)
                    descripcion.setText("1/4 de 3 gustos")
                }
            }


            // para poder atar en el activity_layout, en el elemento muestroPeididoLayout lo invocamos con un addView
            muestroPedidoLayout.removeAllViews()
            muestroPedidoLayout.addView(view)
        })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_heladeria,menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menu_home->{
                    Toast.makeText(this,"Estas parado en la actividad main ",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_desp->{
                startActivity(Intent(this,DespachanteActivity::class.java))
                true
            }
            else->{
                true
            }
        }
    }

}