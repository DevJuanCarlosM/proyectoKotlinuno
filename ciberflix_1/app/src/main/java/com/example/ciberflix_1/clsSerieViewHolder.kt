package com.example.ciberflix_1

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_pelicula.view.*
import kotlinx.android.synthetic.main.item_serie.view.*

class clsSerieViewHolder(vista: View) : RecyclerView.ViewHolder(vista){

    fun llenarInfoSeries(miSerie: clsSerie){

        itemView.imgSerie.setImageUrl(miSerie?.urlImagenSerie)
    }

}