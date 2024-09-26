package com.istea.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.istea.dto.Persona

class DBHelper(context: Context,factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME,factory,DATABASE_VERSION) {


    companion object{
        private val DATABASE_NAME = "persona.db"
        private val DATABASE_VERSION=1
        val TABLA_PERSONA ="persona"
        val COLUMN_ID ="id"
        val COLUMN_NOMBRE ="nombre"
        val COLUMN_APELLIDO="apellido"
        val COLUMN_EDAD="edad"
        var ID:Int=0

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE "+ TABLA_PERSONA + " ( " +
                COLUMN_ID +" INTEGER PRIMARY KEY, " +
                COLUMN_NOMBRE + " TEXT," +
                COLUMN_APELLIDO +" TEXT, " +
                COLUMN_EDAD +" INTEGER " +
                ")")


        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        // condicion si cambio la version de la base de datos o la estructura

       // if(oldVersion != newVersion){ generar backup y ejecutar el drop de la tabla + la creacion}

        db?.execSQL("DROP TABLE IF EXISTS" + TABLA_PERSONA)
        onCreate(db)
    }


    fun guardarPersona(persona: Persona){
        // necesito recuperar el objeto db y escribir en la base de datos

        val db = this.writableDatabase // vamos a escribir en la base

        // INSERT INTO TABLA ( CAMPO1,CAMPO2,CAMPON) VALUES (VALOR1,VALOR2,VALORN)

        val values = ContentValues()

        values.put(COLUMN_NOMBRE,persona.nombre)
        values.put(COLUMN_APELLIDO,persona.apellido)
        values.put(COLUMN_EDAD,persona.edad)

        db.insert(TABLA_PERSONA,null,values)

    }


    fun obtenerPersonas():ArrayList<Persona>{

        val listaPersona: ArrayList<Persona> = ArrayList<Persona>();
        // logica de recupero de personas

        val query = "SELECT * FROM "+ TABLA_PERSONA

        // queremos leer la base de datos!
        val db= this.readableDatabase

        // que me retorne una lista // select * from  tabla where campo = valor
        val cursor = db.rawQuery(query,null)

        // el cursor tiene todos los elementos de mi vista ( resultado del query select)

        if(cursor.moveToFirst()){

            do{
                ID =  cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val apellido = cursor.getString(cursor.getColumnIndex(COLUMN_APELLIDO))
                val edad = cursor.getInt(cursor.getColumnIndex(COLUMN_EDAD))

                listaPersona.add(Persona(nombre,apellido,edad))

            }while(cursor.moveToNext())
        }


        return listaPersona
    }

    fun modificarPersonaNombre(nombre:String){

        val db = this.writableDatabase

        val values = ContentValues()

        values.put(COLUMN_NOMBRE,nombre)

        db.update(TABLA_PERSONA,values, "id = 1" ,null)





    }


    // update tabla set columna = valor where id = 1

}