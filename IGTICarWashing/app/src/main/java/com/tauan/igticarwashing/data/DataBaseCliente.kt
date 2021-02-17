package com.tauan.igticarwashing.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val TABLE_NAME = "Clientes"                   //nome da tabela
const val DB_NAME = "dataBaseClientes.db"           //nome do banco de dados
const val DB_VERSION = 1                            //versão do banco de dados
const val COL_NAME = "name"                         //Coluna name
const val COL_TIPO_VEICULO = "veiculo"      //coluna tipo de veiculo
const val COL_PLACA = "placa"                       //Coluna telephone
const val COL_ID = "id"                             //Coluna id

class DataBaseCliente(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql =
            "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_PLACA TEXT, $COL_TIPO_VEICULO TEXT);"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(sql)
        onCreate(db)
    }

}