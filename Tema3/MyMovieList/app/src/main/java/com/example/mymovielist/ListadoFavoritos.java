package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListadoFavoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_favoritos);
        ListView lvFavs=findViewById(R.id.lvFavs);
        PeliculasRepository pelisFavs=new PeliculasRepository();

        pelisFavs.rellenaPeliculas();

    }
}
