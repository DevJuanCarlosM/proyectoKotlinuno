package com.example.ciberflix_1

import java.io.FileDescriptor
import java.io.Serializable


class clsSerie(

    val idSerie : Int,
    val nombreSerie: String,
    val fechaInicioSerie: String,
    val paisSerie: String,
    val networkSerie: String,
    val estadoSerie: String,
    val urlImagenSerie: String
) : Serializable