package com.example.ciberflix_1

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_pelicula.view.*


class clsPeliculaViewHolder(vista: View) : RecyclerView.ViewHolder(vista){

    fun llenarInfoPeliculas(miPelicula: clsPelicula){


        itemView.imgPelicula.setImageUrl(miPelicula.imagen)

    }

}