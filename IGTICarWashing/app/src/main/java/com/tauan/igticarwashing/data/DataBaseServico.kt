package com.tauan.igticarwashing.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DB_NOME = "servicos.db"
const val DB_VERSAO = 1
const val TABLE_NOME = "Serviços"
const val C_CLIENTE = "Cliente"
const val C_VEICULO = "Veículo"
const val C_PLACA = "Placa"
const val COL_TIPO_SERVICO = "Tipo-de-servico"

class DataBaseServico(context: Context) : SQLiteOpenHelper(context, DB_NOME, null, DB_VERSAO) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql =
            "CREATE TABLE $TABLE_NOME($C_CLIENTE TEXT, $C_PLACA TEXT, $C_VEICULO TEXT, $COL_TIPO_SERVICO TEXT);"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_NOME"
        db?.execSQL(sql)
        onCreate(db)
    }
}