package com.tauan.igticarwashing.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tauan.igticarwashing.R
import com.tauan.igticarwashing.model.Menu
import kotlinx.android.synthetic.main.item_cliente.view.*


class AdapterClientes(private val listMenu : List<Menu>) : RecyclerView.Adapter<AdapterClientes.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder {
        val itemMenu : View = LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent, false)
        return MyViewHolder(itemMenu)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewBind(listMenu[position])
    }

    override fun getItemCount(): Int = 4

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val title = itemView.titleBtnMenu
        private val image = itemView.imageBtnMenu

        fun viewBind(menu : Menu){
            title.text = menu.title
            image.setImageResource(menu.image)
        }
    }
}