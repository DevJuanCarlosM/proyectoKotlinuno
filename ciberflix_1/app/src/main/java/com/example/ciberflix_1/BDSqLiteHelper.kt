package com.example.ciberflix_1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDSqLiteHelper(context: Context, nombreBD: String, factory: SQLiteDatabase.CursorFactory?,
                     version: Int) : SQLiteOpenHelper(context, nombreBD, factory, version) {


    val sqlCreate = "CREATE TABLE USUARIO (Nombres TEXT, Apellidos TEXT, Pais TEXT, Genero TEXT, Correo TEXT, Contraseña TEXT, ConfContraseña TEXT)"

    val sqlBorrarTabla = "DROP TABLE IF EXISTS USUARIO"


    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL(sqlBorrarTabla)
        db?.execSQL(sqlCreate)
    }







}