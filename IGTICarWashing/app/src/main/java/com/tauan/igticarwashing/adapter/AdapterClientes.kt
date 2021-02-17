package com.tauan.igticarwashing.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tauan.igticarwashing.R
import com.tauan.igticarwashing.model.Cliente
import kotlinx.android.synthetic.main.item_cliente.view.*


class AdapterClientes(private val listCliente: List<Cliente>) :
    RecyclerView.Adapter<AdapterClientes.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemMenu: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent, false)
        return MyViewHolder(itemMenu)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewBind(listCliente[position])
    }

    override fun getItemCount(): Int = listCliente.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nome = itemView.textNomeCliente
        private val placa = itemView.textPlacaCliente
        private val veiculo = itemView.textVeiculo

        fun viewBind(cliente: Cliente) {
            nome.text = cliente.nome
            placa.text = cliente.placa
            veiculo.text = cliente.veiculo
        }
    }
}