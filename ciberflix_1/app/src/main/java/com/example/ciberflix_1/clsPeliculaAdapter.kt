package com.example.ciberflix_1

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class clsPeliculaAdapter(val listaPeliculas : List<clsPelicula>,  val onClick : (clsPelicula) -> Unit) : RecyclerView.Adapter<clsPeliculaViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): clsPeliculaViewHolder {
        return clsPeliculaViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_pelicula,p0, false)
        )
    }
    override fun getItemCount(): Int {
        return listaPeliculas.size
    }

    override fun onBindViewHolder(p0: clsPeliculaViewHolder, p1: Int) {
        val pelicula = listaPeliculas[p1]
        p0.llenarInfoPeliculas(pelicula)
        p0.itemView.setOnClickListener {
            onClick(pelicula)
        }

    }


}