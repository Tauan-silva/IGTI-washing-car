package com.tauan.igticarwashing.presentation.layout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tauan.igticarwashing.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardCadastroCliente.setOnClickListener(this)
        cardAgenda.setOnClickListener(this)
        cardAgendaServico.setOnClickListener(this)
        cardListaCliente.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.cardCadastroCliente) {
            val intent = Intent(this, CadastroClienteActivity::class.java)
            startActivity(intent)
        } else if (view.id == R.id.cardAgenda) {
            val intent = Intent(this, AgendaActivity::class.java)
            startActivity(intent)
        } else if (view.id == R.id.cardAgendaServico) {
            val intent = Intent(this, ServicoActivity::class.java)
            startActivity(intent)
        } else if (view.id == R.id.cardListaCliente) {
            val intent = Intent(this, ListaClienteActivity::class.java)
            startActivity(intent)
        }
    }
}