package com.example.ciberflix_1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class clsSerieAdapter(val listaSeries : List<clsSerie>, val onclick : (clsSerie) -> Unit) : RecyclerView.Adapter<clsSerieViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): clsSerieViewHolder {
        return clsSerieViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_serie,p0, false)
        )
    }


    override fun getItemCount(): Int {
        return listaSeries.size
    }

    override fun onBindViewHolder(p0: clsSerieViewHolder, p1: Int) {
        val serie = listaSeries[p1]
        p0.llenarInfoSeries(serie)
        p0.itemView.setOnClickListener(){
            onclick(serie)
        }


    }


}