package com.example.ciberflix_1

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_dt_serie.*
import org.json.JSONArray
import org.json.JSONObject

class activity_dtSerie : AppCompatActivity() {

    val urlServicio = "https://www.episodate.com/api/show-details?q="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dt_serie)

        val extras = intent.extras
        val XXX= extras["OBJETO_SERIE"] as? clsSerie


        if(extras != null){
            val SERIE = extras["OBJETO_SERIE"] as? clsSerie

            imgSerie.setImageUrl(SERIE?.urlImagenSerie)
            lblNombreSerie.text = SERIE?.nombreSerie?: ""
            lblFechaInicioSerie.text = SERIE?.fechaInicioSerie?: ""
            lblPaisSerie.text = SERIE?.paisSerie?: ""
            lblNetworkSerie.text = SERIE?.networkSerie?: ""
            lblEstadoSerie.text = SERIE?.estadoSerie?: ""
        }


        btnReproducirSerie.setOnClickListener{
            val i = Intent(this,activity_dtVerSerie::class.java)
            startActivity(i)
        }
      AndroidNetworking.get(urlServicio+XXX?.idSerie.toString())
          .build()
          .getAsJSONObject(object : JSONObjectRequestListener{
              override fun onResponse(response: JSONObject?) {
                  println(">>"+urlServicio+XXX?.idSerie)
                  if (response != null) {
                      var TV_SHOW = response["tvShow"] as JSONObject
                      val description = TV_SHOW["description"] as? String ?: ""
                      val episode = TV_SHOW["episodes"] as JSONArray

                      var url = TV_SHOW["url"] as? String ?:""

                      for (x in 0 until episode.length()) {
                          val CAPITULO = episode[x] as JSONObject
                          var season = CAPITULO["season"] as Int
                          var epi = CAPITULO["episode"] as Int
                          var name = CAPITULO["name"] as String

                          println(">>> $season x $epi : $name")

                      }
                      btnReproducirSerie.setOnClickListener {
                          val uri = Uri.parse(url)
                          val intent = Intent(Intent.ACTION_VIEW,uri)
                          startActivity(intent)
                      }

                      lblDescripcionSerie.text = description.toString()
                  }

              }

              override fun onError(anError: ANError?) {}

          })


    }
}
