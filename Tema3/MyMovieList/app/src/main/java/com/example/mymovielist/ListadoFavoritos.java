package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoFavoritos extends AppCompatActivity {
    AdaptadorFavoritos adaptadorFavoritos;
    ArrayList<Pelicula> pelisFavs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_favoritos);
        final ListView lvFavs = findViewById(R.id.lvFavs);

        final PeliculasRepository pelisGet = new PeliculasRepository();
        final CheckBox chkFav = findViewById(R.id.chkFav);

        pelisFavs = pelisGet.rellenaPeliculas();
        adaptadorFavoritos = new AdaptadorFavoritos(this, pelisFavs);
        lvFavs.setAdapter(adaptadorFavoritos);



    }
}
