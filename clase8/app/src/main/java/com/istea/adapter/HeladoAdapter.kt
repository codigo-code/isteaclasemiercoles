package com.istea.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.istea.R
import com.istea.modelo.Helado

class HeladoAdapter(private val dataSet: ArrayList<Helado>) :RecyclerView.Adapter<HeladoAdapter.ViewHolder>()
{


    //Necesitamos crearnos una inner class que responda a la vinculacion de los objetos
    // de mi layout helado_item.xml

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val desc:TextView
        val precio:TextView
        val foto:ImageView
        val comprar:Button

        init {
            // en este punto no sabe cual es la  vista asociada
            desc = view.findViewById(R.id.hi_desc)
            precio=view.findViewById(R.id.hi_precio)
            foto=view.findViewById(R.id.hi_foto)
            comprar = view.findViewById(R.id.hi_comprar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // el contexto de donde estoy parado es dinamico
        // lo vamos a utilizar en el activity_main --->
        val view = LayoutInflater.from(parent.context).inflate(R.layout.helado_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.desc.text = "Helado: " + dataSet[position].desc
        holder.precio.text = "Precio: " +dataSet[position].precio.toString()  + "$"
        holder.foto.setImageResource(dataSet[position].foto)
        holder.comprar.setOnClickListener(

            View.OnClickListener {
                //
                val valorConDescuento = (dataSet[position].precio*0.6)
                holder.desc.text = valorConDescuento.toString()
                val builder = AlertDialog.Builder(it.context)
                builder.setTitle("Desea comprar el "+ dataSet[position].desc+ "?")
                builder.setMessage("Tiene un 40% descuento con club ISTEA! te queda en: " + valorConDescuento + "!!")
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                // si presion " OK " o "SI" o lo que nosotros digamos , hara una accion
                // tengamos en cuenta que las acciones son positivas, neustras o negativas

                builder.setPositiveButton("Comprar"){dialogInterface, i -> Toast.makeText(it.context,dataSet[position].desc + " comprado" , Toast.LENGTH_SHORT).show() }
                builder.setNegativeButton("No"){dialogInterface, i ->  Toast.makeText(it.context,"el precio "+valorConDescuento + ", es demasiado alto",Toast.LENGTH_SHORT).show()}
                builder.setNeutralButton("Cancelar"){dialogInterface, i -> Toast.makeText(it.context,"operacion cancelada",Toast.LENGTH_SHORT).show() }

                val alerta:AlertDialog = builder.create()
                alerta.setCancelable(false)
                alerta.show()
            }
        )

    }
}