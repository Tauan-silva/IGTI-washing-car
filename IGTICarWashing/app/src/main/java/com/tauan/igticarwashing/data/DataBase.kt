package com.tauan.igticarwashing.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.tauan.igticarwashing.model.Cliente

const val TABLE_NAME = "Clientes"          //nome da tabela
const val DB_NAME = "dataBaseClientes.db"  //nome do banco de dados
const val DB_VERSION = 1                  //versão do banco de dados
const val COL_NAME = "name"               //Coluna name
const val COL_TELEPHONE = "telefone"      //Coluna telephone
const val COL_ID = "id"                   //Coluna id

class DataBase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_TELEPHONE TEXT);"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun addCliente(cliente: Cliente): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_NAME, cliente.nome)
        values.put(COL_TELEPHONE, cliente.telefone)
        val result = db.insert(TABLE_NAME, null, values)
        return (("$result").toInt() != -1)
    }
}