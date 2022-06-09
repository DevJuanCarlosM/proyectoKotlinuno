package com.example.ciberflix_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)


        btnUsuario.setOnClickListener {
            var usuIntent = Intent(this, Usuario::class.java)

            startActivity(usuIntent)
        }
        btnPelicula.setOnClickListener {
            var peliIntent = Intent(this, PeliculasActivity::class.java)
            startActivity(peliIntent)
        }

        btnSeries.setOnClickListener {
            var serieIntent = Intent(this, SeriesActivity::class.java)
            startActivity(serieIntent)
        }

        //Boton EN OBSERVACION
        btnRegU.setOnClickListener {

            var botonRegU = Intent(this, activity_login::class.java)
            startActivity(botonRegU)

        }


    }




}
