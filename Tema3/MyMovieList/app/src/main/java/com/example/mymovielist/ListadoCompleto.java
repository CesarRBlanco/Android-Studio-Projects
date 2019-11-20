package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListadoCompleto extends AppCompatActivity {


    PeliculasRepository peliculasRepository = new PeliculasRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_completo);
        ArrayList<Pelicula> pelisCompletas = new ArrayList<>();
        pelisCompletas = peliculasRepository.rellenaPeliculas();

        RecyclerView rvCompleto = findViewById(R.id.rvCompleto);

        final AdaptadorListado adaptadorListado = new AdaptadorListado(pelisCompletas, rvCompleto);
        GridLayoutManager gy = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rvCompleto.setLayoutManager(gy);
        rvCompleto.setAdapter(adaptadorListado);

    }
}
