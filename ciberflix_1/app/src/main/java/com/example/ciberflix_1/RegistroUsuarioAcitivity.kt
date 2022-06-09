package com.example.ciberflix_1

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrousuario.*

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrousuario)


        /** Creamos la BD (si no esta creada) y la Referencia*/
        val sqLiteHelper = BDSqLiteHelper(this, "ProyectoBD",  null, 1)

        /**Boton Registrar*/
        btnRegistroUsuario.setOnClickListener {

            /** Abrimos la BD en modo escritura */
            val ProyectoBD = sqLiteHelper.writableDatabase


            /** Obtenemos los valores*/
            val Nombres        = txtNombre5.text.toString()
            val Apellidos      = txtApellido.text.toString()
            val Pais           = txtPais.text.toString()
            val Genero         = txtGenero.text.toString()
            val Correo         = txtCorreo5.text.toString()
            val Contraseña     = txtContraseña.text.toString()
            val ConfContraseña = txtConfirmarContraseña.text.toString()


            if(!Nombres.isEmpty() && !Apellidos.isEmpty() && !Pais.isEmpty() && !Genero.isEmpty() && !Correo.isEmpty() && !Contraseña.isEmpty() && !ConfContraseña.isEmpty()){

                /** Agregamos los valores*/
                val nuevoUsuario = ContentValues()


                nuevoUsuario.put("Nombres", Nombres)
                nuevoUsuario.put("Apellidos", Apellidos)
                nuevoUsuario.put("Pais", Pais)
                nuevoUsuario.put("Genero", Genero)
                nuevoUsuario.put("Correo", Correo)
                nuevoUsuario.put("Contraseña", Contraseña)
                nuevoUsuario.put("ConfContraseña", ConfContraseña)


                ProyectoBD.insert("USUARIO", null, nuevoUsuario)

                ProyectoBD.close()
                /**println(nuevoUsuario)*/

                /**limpia los campos*/
                txtNombre5.setText("")
                txtApellido.setText("")
                txtPais.setText("")
                txtGenero.setText("")
                txtCorreo5.setText("")
                txtContraseña.setText("")
                txtConfirmarContraseña.setText("")

                Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Debe llenar todos los Campos", Toast.LENGTH_SHORT).show()
            }
        }












    }
}
