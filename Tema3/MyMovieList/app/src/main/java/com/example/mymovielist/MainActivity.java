package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Pelicula> pelis = new ArrayList<>();
    ArrayList<Pelicula> pelis2 = new ArrayList<>();
    PeliculasRepository peliculasRepository = new PeliculasRepository();
    RecyclerView rv;
    RecyclerView rvSelec;
    final ArrayList<String> lista = new ArrayList<String>(); // Fuente de datos
    ArrayAdapter<String> adapter;
    ConstraintLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pelis = peliculasRepository.rellenaPeliculas();
        Button txtM = findViewById(R.id.button);


            lista.add("Hi");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        rv = findViewById(R.id.recyclerView);

        final Adaptador adaptador = new Adaptador(pelis, rv);
        GridLayoutManager gy = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
       final GridLayoutManager gy2 = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gy);
        rv.setAdapter(adaptador);
        frame=findViewById(R.id.mainConstrain);
        frame.findViewById(R.id.divider).setVisibility(View.INVISIBLE);
        txtM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportActionBar().isShowing()) {
                    getSupportActionBar().hide();
                } else {
                    getSupportActionBar().show();
                }
            }
        });

        View.OnClickListener pulsador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=rv.getChildAdapterPosition(v);
                Toast.makeText(MainActivity.this, pelis.get(pos).getTitulo(), Toast.LENGTH_SHORT).show();
                rvSelec=findViewById(R.id.rvSelec);
                pelis2 = peliculasRepository.selecMovie(pelis,pos);
                Adaptador adaptador1=new Adaptador(pelis2,rvSelec);
                rvSelec.setLayoutManager(gy2);
                rvSelec.setAdapter(adaptador1);
                frame.findViewById(R.id.divider).setVisibility(View.VISIBLE);

            }
        };

        adaptador.setListener(pulsador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return true;
    }
}
