package com.tauan.igticarwashing.presentation.layout

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tauan.igticarwashing.R
import com.tauan.igticarwashing.data.*
import kotlinx.android.synthetic.main.activity_cadastro_cliente.*

class CadastroClienteActivity : AppCompatActivity() {

    private val dataHelper = DataBaseCliente(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        btnSalvarCadastro.setOnClickListener {
            if (editNomeCliente.text.isEmpty() || editPlaca.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Por favor, preencha todas as informações",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                //inserindo valores no banco de dados
                val db: SQLiteDatabase = dataHelper.writableDatabase
                val values = ContentValues()
                values.put(COL_NAME, editNomeCliente.text.toString())
                values.put(COL_PLACA, editPlaca.text.toString())
                if (radioBtnCarro.isChecked) {
                    values.put(COL_TIPO_VEICULO, radioBtnCarro.text.toString())
                } else if (radioBtnMoto.isChecked) {
                    values.put(COL_TIPO_VEICULO, radioBtnMoto.text.toString())
                }
                db.insertOrThrow(TABLE_NAME, null, values)

                //informando que o cliente foi cadastrado e limpando os campos para novos cadastros
                Toast.makeText(
                    this,
                    "Cliente cadastrado com sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                editNomeCliente.text.clear()
                editPlaca.text.clear()
            }
        }
    }
}