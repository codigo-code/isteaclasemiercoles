package edu.istea.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import edu.istea.model.User
import java.lang.Exception

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "saludable.db"
        private val DATABASE_VERSION = 3
        val TABLE_USER = "users"
        val COLUMN_NAME = "name"
        val COLUMN_PASS = "pass"
        val COLUMN_ID = "id"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createTableUser = ("CREATE TABLE " + TABLE_USER +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_PASS + " TEXT )"
                )

        db?.execSQL(createTableUser)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_USER)
        onCreate(db)
    }

    fun saveUser(user: User) {
        var db = this.writableDatabase

        val values = ContentValues()

        values.put(COLUMN_NAME, user.name)
        values.put(COLUMN_PASS, user.pass)
        try {
            db.insert(TABLE_USER, null, values)
        } catch (e: Exception) {
            Log.e("error insert", e.message.toString())
        }


    }

    // validamos si el usuario esta en la base de datos , sino devuelve falso
    fun validateUser(user: User): Boolean {

        var db = this.readableDatabase

        var query = "SELECT * FROM " + TABLE_USER

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {
                val nameDB = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val passDB = cursor.getString(cursor.getColumnIndex(COLUMN_PASS))
                // == compara valor literal equals compara valor + tipe
                if (user.name.equals(nameDB) && user.pass.equals(passDB)) {
                    return true
                }

            } while (cursor.moveToNext())
        }

        return false

    }
}