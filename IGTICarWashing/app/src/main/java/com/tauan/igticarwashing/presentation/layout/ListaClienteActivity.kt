package com.tauan.igticarwashing.presentation.layout

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tauan.igticarwashing.R
import com.tauan.igticarwashing.adapter.AdapterClientes
import com.tauan.igticarwashing.data.*
import com.tauan.igticarwashing.model.Cliente
import kotlinx.android.synthetic.main.activity_lista_cliente.*

class ListaClienteActivity : AppCompatActivity() {

    private val dataHelper = DataBaseCliente(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_cliente)

        supportActionBar?.hide()

        with(recyclerListCliente) {
            adapter = AdapterClientes(getCliente())
            layoutManager =
                LinearLayoutManager(this@ListaClienteActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(this@ListaClienteActivity, LinearLayout.VERTICAL)
            )

        }

    }

    private fun getCliente(): List<Cliente> {
        val listCliente: ArrayList<Cliente> = arrayListOf()
        val db: SQLiteDatabase = dataHelper.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val cliente = Cliente(
                        cursor.getString(cursor.getColumnIndex(COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(COL_PLACA)),
                        cursor.getString(cursor.getColumnIndex(COL_TIPO_VEICULO))
                    )
                    listCliente.add(cliente)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return listCliente
    }
}