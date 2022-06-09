package com.example.ciberflix_1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class UsuarioAdapter(val listaUsu : List<UsuarioItemRecycleView>) : RecyclerView.Adapter<UsuarioViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UsuarioViewHolder {
        return UsuarioViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_usuario, p0, false))
    }

    override fun getItemCount(): Int {

        return listaUsu.size
    }

    override fun onBindViewHolder(p0: UsuarioViewHolder, p1: Int) {

        val unUsu = listaUsu[p1]
        p0.llenarDatos(unUsu)
    }


}