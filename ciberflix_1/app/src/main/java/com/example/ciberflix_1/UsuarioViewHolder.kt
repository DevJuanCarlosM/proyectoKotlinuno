package com.example.ciberflix_1

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_usuario.view.*

class UsuarioViewHolder(mivista : View) : RecyclerView.ViewHolder(mivista) {


    fun llenarDatos(mius : UsuarioItemRecycleView){

        itemView.lblNombrePel.text = mius.NombrePelicula
    }

}