package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Pelicula> pelis = new ArrayList<>();
    PeliculasRepository peliculasRepository = new PeliculasRepository();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pelis = peliculasRepository.rellenaPeliculas();
        rv = findViewById(R.id.recyclerView);
Adaptador adaptador=new Adaptador(pelis,rv);
        GridLayoutManager gy = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gy);
        rv.setAdapter(adaptador);

    }
}
