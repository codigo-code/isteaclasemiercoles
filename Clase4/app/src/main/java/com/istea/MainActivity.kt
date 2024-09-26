package com.istea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var b_uno:Button
    lateinit var b_dos:Button
    lateinit var b_tres:Button
    lateinit var b_cuatro:Button
    lateinit var b_cinco:Button
    lateinit var b_seis:Button
    lateinit var b_siete:Button
    lateinit var b_ocho:Button
    lateinit var b_nueve:Button
    lateinit var b_mas:Button
    lateinit var b_menos:Button
    lateinit var b_igual:Button
    lateinit var t_cualculo:TextView
    lateinit var b_borrar:Button
    lateinit var b_goToMessage:Button
    lateinit var b_gotToFragment:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initilizationElements()

        aritmetica()

        borrarCalculadora()


        b_goToMessage.setOnClickListener(
            View.OnClickListener {
                val i :Intent= Intent(this,MessageActivity::class.java)
                startActivity(i)
            }
        )
        b_gotToFragment.setOnClickListener(
            View.OnClickListener {
                val i :Intent= Intent(this,FragmentActivity::class.java)
                startActivity(i)
            }
        )


    }



    private fun aritmetica(){
        b_uno.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "1"
            }
        )
        b_dos.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "2"
            }
        )

        b_tres.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "3"
            }
        )
        b_cuatro.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "4"
            }
        )
        b_cinco.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "5"
            }
        )
        b_seis.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "6"
            }
        )
        b_siete.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "7"
            }
        )
        b_ocho.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "8"
            }
        )
        b_nueve.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "9"
            }
        )
        b_igual.setOnClickListener(
            View.OnClickListener {
                // IMPORTANTE TIENE QUE SER UNA OPERACION ARITMETICA --> X+Y
                // dara error cuando se ponga X-+/Y
                val expression = ExpressionBuilder(t_cualculo.text.toString()).build()
                t_cualculo.text = expression.evaluate().toString()
            }
        )
        b_mas.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "+"
            }
        )
        b_menos.setOnClickListener(
            View.OnClickListener {
                t_cualculo.text = t_cualculo.text.toString() + "-"
            }
        )
    }

    private fun borrarCalculadora(){
        b_borrar.setOnClickListener(
            View.OnClickListener {
                t_cualculo.setText("")
            }
        )

    }

    private fun initilizationElements(){
        b_uno=findViewById(R.id.m_b_1)
        b_dos=findViewById(R.id.m_b_2)
        b_tres=findViewById(R.id.m_b_3)
        b_cuatro=findViewById(R.id.m_b_4)
        b_cinco=findViewById(R.id.m_b_5)
        b_seis=findViewById(R.id.m_b_6)
        b_siete=findViewById(R.id.m_b_7)
        b_ocho=findViewById(R.id.m_b_8)
        b_nueve=findViewById(R.id.m_b_9)
        b_mas=findViewById(R.id.m_b_mas)
        b_menos=findViewById(R.id.m_b_menos)
        b_igual=findViewById(R.id.m_b_igual)
        t_cualculo=findViewById(R.id.m_t_calculo)
        b_borrar=findViewById(R.id.m_b_borrar)
        b_goToMessage=findViewById(R.id.m_b_gotomessage)
        b_gotToFragment=findViewById(R.id.m_b_gotofragment)


    }
}