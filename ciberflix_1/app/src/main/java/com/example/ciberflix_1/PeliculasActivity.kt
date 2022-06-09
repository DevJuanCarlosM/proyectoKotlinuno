package com.example.ciberflix_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError

import org.json.JSONArray
import org.json.JSONObject

import kotlin.collections.ArrayList
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_peliculas.*

class PeliculasActivity : AppCompatActivity() {
     val urlservicio = "https://yts.lt/api/v2/list_movies.json?quality=3D"
     val Lista_Peliculas = ArrayList<clsPelicula>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        rvPeliculas.layoutManager = GridLayoutManager(this@PeliculasActivity,3)

        AndroidNetworking.get(urlservicio)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    if (response != null) {
                        var data = response["data"] as JSONObject
                        var movie = data["movies"] as JSONArray

                        for (x in 0 until movie.length()) {
                            var objectsmovie = movie[x] as JSONObject
                            var direccion = objectsmovie["url"] as? String ?: ""
                            var titulo = objectsmovie["title"]as? String ?: ""
                            var imagen = objectsmovie["medium_cover_image"]as? String ?: ""
                            var descripcion = objectsmovie["description_full"]as? String ?: ""


                            var id = objectsmovie["id"] as Int
                            println("id: " + id)
                            println("url: " + direccion)
                            println("titulo: " + titulo)
                            println("imagen: " + imagen)
                            println("descripcion: " + descripcion)

                            var miMovie = clsPelicula(id, titulo, imagen, direccion, descripcion
                            )
                            Lista_Peliculas.add(miMovie)
                        }
                        rvPeliculas.adapter = clsPeliculaAdapter(Lista_Peliculas){mipelicula ->
                            var segunda = Intent(this@PeliculasActivity,activity_dtPelicula::class.java)
                            segunda.putExtra("OBJETO",mipelicula)
                            startActivity(segunda)
                        }
                    }
                }
                override fun onError(anError: ANError?) {}
            })
    

        }


    }


