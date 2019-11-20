package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoFavoritos extends AppCompatActivity {
    AdaptadorFavoritos adaptadorFavoritos;
    ArrayList<Pelicula> pelisFavs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_favoritos);
        ListView lvFavs = findViewById(R.id.lvFavs);
        PeliculasRepository pelisGet = new PeliculasRepository();
        pelisFavs = pelisGet.rellenaPeliculas();
        adaptadorFavoritos = new AdaptadorFavoritos(this, pelisFavs);
        lvFavs.setAdapter(adaptadorFavoritos);

    }
}
