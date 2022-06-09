package com.example.ciberflix_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class activity_login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lblRegistrate.setOnClickListener(){
            val miIntent = Intent(this,Registro::class.java)
            startActivity(miIntent)
        }


        btnIniciarSesion.setOnClickListener {

            val sqLiteHelper = BDSqLiteHelper(this, "ProyectoBD",  null, 1)

            val ProyectoBD = sqLiteHelper.readableDatabase

            val cursor = ProyectoBD.rawQuery("SELECT Nombres, Apellidos, Pais, Genero, Correo, Contraseña, ConfContraseña FROM USUARIO WHERE Correo=? AND Contraseña=?", null)

            if(cursor.moveToFirst()){

                do{

                    val Nombres        = cursor.getString(0)
                    val Apellidos      = cursor.getString(1)
                    val Pais           = cursor.getString(2)
                    val Genero         = cursor.getString(3)
                    val Correo         = cursor.getString(4)
                    val Contraseña     = cursor.getString(5)
                    val ConfContraseña = cursor.getString(6)

                    /*
                    println(Nombres)
                    println(Apellidos)
                    println(Pais)
                    println(Genero)
                    println(Correo)
                    println(Contraseña)
                    println(ConfContraseña)
                    println("----------------------------")
                    */

                }while(cursor.moveToNext())
            }
            cursor.close()
            ProyectoBD.close()

            txtUsuarioLogin.setText("")
            h.setText("")

            Toast.makeText(this, "Bienvenido Usuario", Toast.LENGTH_SHORT).show()
        }






    }
}
