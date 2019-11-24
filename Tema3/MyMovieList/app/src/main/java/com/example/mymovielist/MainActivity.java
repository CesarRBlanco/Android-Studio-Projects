package com.example.mymovielist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    static ArrayList<Pelicula> pelis = new ArrayList<>();
    ArrayList<Pelicula> peliSelec = new ArrayList<>();
    PeliculasRepository peliculasRepository = new PeliculasRepository();
    RecyclerView rv;
    RecyclerView rvSelec;
    ConstraintLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pelis = peliculasRepository.rellenaPeliculas();
        final Button txtM = findViewById(R.id.button);
        rv = findViewById(R.id.rvMain);
        

        final Adaptador adaptador = new Adaptador(pelis, rv);
        GridLayoutManager gy = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        final GridLayoutManager gy2 = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gy);
        rv.setAdapter(adaptador);
        frame = findViewById(R.id.mainConstrain);
        frame.findViewById(R.id.divider).setVisibility(View.VISIBLE);
        txtM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportActionBar().isShowing()) {
                    getSupportActionBar().hide();
                    txtM.setText("Mostrar Barra");
                } else {
                    getSupportActionBar().show();
                    txtM.setText("Ocultar Barra");
                }
            }
        });

        final View.OnClickListener pulsador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rv.getChildAdapterPosition(v);
                rvSelec = findViewById(R.id.rvSelec);


                peliSelec = peliculasRepository.selecMovie(pelis, pos);

                AdaptadorSelec adaptador1 = new AdaptadorSelec(peliSelec, rvSelec);
                rvSelec.setLayoutManager(gy2);
                rvSelec.setAdapter(adaptador1);
                frame.findViewById(R.id.textView).setVisibility(View.GONE);

            }
        };

        adaptador.setListener(pulsador);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.fullList:
                Intent intentFullList = new Intent(MainActivity.this, ListadoCompleto.class);
                startActivity(intentFullList);
                break;
            case R.id.favs:
                Intent intentFavsList = new Intent(MainActivity.this, ListadoFavoritos.class);
                startActivity(intentFavsList);
                break;
            case R.id.add:
                Intent intentAdd = new Intent(MainActivity.this, NuevaPelicula.class);
                startActivity(intentAdd);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
