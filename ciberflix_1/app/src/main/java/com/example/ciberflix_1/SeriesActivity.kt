package com.example.ciberflix_1

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_series.*
import kotlinx.android.synthetic.main.item_serie.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URI

class SeriesActivity : AppCompatActivity() {



    var LISTA_SERIES = ArrayList<clsSerie>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series)


        val url ="https://www.episodate.com/api/most-popular?page=2"


        btnBuscar.setOnClickListener {
            var busca = txtSerie.text
            val urlServicio = "https://www.episodate.com/api/search?q=$busca"

            LISTA_SERIES.clear()
            AplicarApi(urlServicio)
        }

        AndroidNetworking.get(url)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    if (response != null) {
                        var TV_SHOWS = response["tv_shows"] as JSONArray

                        for (x in 0 until TV_SHOWS.length()) {

                            val SERIE = TV_SHOWS[x] as JSONObject

                            var VALUE_ID_SERIE = SERIE["id"] as Int
                            var VALUE_NOMBRE_SERIE = SERIE["name"] as? String ?: ""
                            var VALUE_FECHA_INICIO_SERIE = SERIE["start_date"] as? String ?: ""
                            var VALUE_PAIS_SERIE = SERIE["country"] as? String ?: ""
                            var VALUE_NETWORK_SERIE = SERIE["network"] as? String ?: ""
                            var VALUE_ESTADO_SERIE = SERIE["status"] as? String ?: ""
                            var VALUE_URL_IMAGEN_SERIE = SERIE["image_thumbnail_path"] as? String ?: ""


                            var OBJETO_SERIE = clsSerie(
                                VALUE_ID_SERIE,
                                VALUE_NOMBRE_SERIE,
                                VALUE_FECHA_INICIO_SERIE,
                                VALUE_PAIS_SERIE,
                                VALUE_NETWORK_SERIE,
                                VALUE_ESTADO_SERIE,
                                VALUE_URL_IMAGEN_SERIE
                            )



                            LISTA_SERIES.add(OBJETO_SERIE)
                            //imgSerie.setImageUrl(OBJETO_SERIE?.urlImagenSerie)

                            println("ID : " + VALUE_ID_SERIE)
                            println("NOMBRE : " + VALUE_NOMBRE_SERIE)
                            println("FECHA INICIO : " + VALUE_FECHA_INICIO_SERIE)
                            println("PAIS : " + VALUE_PAIS_SERIE)
                            println("NETWORK : " + VALUE_NETWORK_SERIE)
                            println("ESTADO : " + VALUE_ESTADO_SERIE)
                            println("URL_IMAGEN : " + VALUE_URL_IMAGEN_SERIE)
                            println("============================")
                        }

                        rvSeries.layoutManager = GridLayoutManager(this@SeriesActivity,3)

                        rvSeries.adapter = clsSerieAdapter(LISTA_SERIES){ miSerie ->
                            println("Dio click")
                            println(miSerie.nombreSerie)

                            val INTENT_DETALLE_SERIE = Intent(this@SeriesActivity,activity_dtSerie::class.java )
                            INTENT_DETALLE_SERIE.putExtra("OBJETO_SERIE", miSerie)
                            startActivity(INTENT_DETALLE_SERIE)
                        }
                    }
                }

                override fun onError(anError: ANError?) {}

            })




    }

    fun AplicarApi(urli:String){
        AndroidNetworking.get(urli)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    if (response != null) {
                        var TV_SHOWS = response["tv_shows"] as JSONArray

                        for (x in 0 until TV_SHOWS.length()) {

                            val SERIE = TV_SHOWS[x] as JSONObject

                            var VALUE_ID_SERIE = SERIE["id"] as Int
                            var VALUE_NOMBRE_SERIE = SERIE["name"] as? String ?: ""
                            var VALUE_FECHA_INICIO_SERIE = SERIE["start_date"] as? String ?: ""
                            var VALUE_PAIS_SERIE = SERIE["country"] as? String ?: ""
                            var VALUE_NETWORK_SERIE = SERIE["network"] as? String ?: ""
                            var VALUE_ESTADO_SERIE = SERIE["status"] as? String ?: ""
                            var VALUE_URL_IMAGEN_SERIE = SERIE["image_thumbnail_path"] as? String ?: ""


                            var OBJETO_SERIE = clsSerie(
                                VALUE_ID_SERIE,
                                VALUE_NOMBRE_SERIE,
                                VALUE_FECHA_INICIO_SERIE,
                                VALUE_PAIS_SERIE,
                                VALUE_NETWORK_SERIE,
                                VALUE_ESTADO_SERIE,
                                VALUE_URL_IMAGEN_SERIE
                            )



                            LISTA_SERIES.add(OBJETO_SERIE)
                            //imgSerie.setImageUrl(OBJETO_SERIE?.urlImagenSerie)

                            println("ID : " + VALUE_ID_SERIE)
                            println("NOMBRE : " + VALUE_NOMBRE_SERIE)
                            println("FECHA INICIO : " + VALUE_FECHA_INICIO_SERIE)
                            println("PAIS : " + VALUE_PAIS_SERIE)
                            println("NETWORK : " + VALUE_NETWORK_SERIE)
                            println("ESTADO : " + VALUE_ESTADO_SERIE)
                            println("URL_IMAGEN : " + VALUE_URL_IMAGEN_SERIE)
                            println("============================")
                        }

                        rvSeries.layoutManager = GridLayoutManager(this@SeriesActivity,3)

                        rvSeries.adapter = clsSerieAdapter(LISTA_SERIES){ miSerie ->
                            println("Dio click")
                            println(miSerie.nombreSerie)

                            val INTENT_DETALLE_SERIE = Intent(this@SeriesActivity,activity_dtSerie::class.java )
                            INTENT_DETALLE_SERIE.putExtra("OBJETO_SERIE", miSerie)
                            startActivity(INTENT_DETALLE_SERIE)
                        }
                    }
                }

                override fun onError(anError: ANError?) {}

            })



    }
    }




