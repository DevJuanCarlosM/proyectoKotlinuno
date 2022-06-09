package com.example.ciberflix_1

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_dt_pelicula.*

class activity_dtPelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dt_pelicula)

        val extras = intent.extras


        if(extras != null) {
            val miobjeto = extras["OBJETO"] as clsPelicula


            val nombrePelicula = miobjeto?.titulo
            val descripcion = miobjeto.descripcion
            val direccion = miobjeto.direccion
            val imagen = miobjeto.imagen




            lblNombrePeliculaDetalle.text = nombrePelicula
            lblDescPelicula.text = descripcion

            if (imagen == null) {
                imgPelicula.background = ContextCompat.getDrawable(imgPelicula.context, R.drawable.mantenimientos!!)
            } else {
                imgPelicula.setImageUrl(miobjeto?.imagen)
            }
            btnReproducir.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(direccion))
                startActivity(i)
            }

        }
    }
}

