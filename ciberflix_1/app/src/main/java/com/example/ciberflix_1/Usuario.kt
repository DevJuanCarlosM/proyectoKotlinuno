package com.example.ciberflix_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_usuario.*
import java.util.ArrayList

class Usuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)



        txtNombre5.text = "Axel Romaní"
        txtCorreo5.text = "AxelRomani94@hotmail.com"



        rvUsuario.layoutManager = LinearLayoutManager(this)

        var listaPelicula = crearLista()

        rvUsuario.adapter = UsuarioAdapter(listaPelicula)

    }

    fun crearLista(): List<UsuarioItemRecycleView>{

        val miLista = ArrayList<UsuarioItemRecycleView>()

        miLista.add(UsuarioItemRecycleView("Avengers"))
        miLista.add(UsuarioItemRecycleView("Harry Potter"))
        miLista.add(UsuarioItemRecycleView("Jumanji"))
        miLista.add(UsuarioItemRecycleView("Rocky"))
        miLista.add(UsuarioItemRecycleView("Rambo"))
        miLista.add(UsuarioItemRecycleView("Terminator"))
        miLista.add(UsuarioItemRecycleView("Xmen"))
        miLista.add(UsuarioItemRecycleView("Robocot"))
        miLista.add(UsuarioItemRecycleView("ALiens"))

        return miLista
    }


}
