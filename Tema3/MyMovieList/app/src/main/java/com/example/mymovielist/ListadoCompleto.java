package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoCompleto extends AppCompatActivity {


    PeliculasRepository peliculasRepository = new PeliculasRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_completo);
        final ArrayList<Pelicula> pelisCompletas;
        pelisCompletas = peliculasRepository.rellenaPeliculas();
        final Intent intentInfo=new Intent(this,PeliculaInfo.class);
        final RecyclerView rvCompleto = findViewById(R.id.rvCompleto);

        final AdaptadorListado adaptadorListado = new AdaptadorListado(pelisCompletas, rvCompleto);
        GridLayoutManager gy = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rvCompleto.setLayoutManager(gy);
        rvCompleto.setAdapter(adaptadorListado);

        final ArrayList<Pelicula> finalPelisCompletas = pelisCompletas;
        View.OnClickListener pulsaInfo=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=rvCompleto.getChildAdapterPosition(v);
                intentInfo.putExtra("Portada",pelisCompletas.get(pos).getPortada());
                intentInfo.putExtra("Sipnosis",pelisCompletas.get(pos).getSinopsis());
                intentInfo.putExtra("Titulo",pelisCompletas.get(pos).getTitulo());
                intentInfo.putExtra("YoutubeId",pelisCompletas.get(pos).getIdYoutube());

            startActivity(intentInfo);

            }
        };
        adaptadorListado.setListener(pulsaInfo);

    }
}
