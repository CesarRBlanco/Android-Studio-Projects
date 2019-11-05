package com.example.libros;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Libros> libros;
    RecyclerView rv;
    int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libros = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            libros.add(new Libros(cont + ". Sueñan?", "Philip k dick", 123, 4.4f, R.drawable.escritor1));
            cont++;
            libros.add(new Libros(cont + ". Mundo anillo", "Larry niven", 234, 2.4f, R.drawable.escritor2));
            cont++;
            libros.add(new Libros(cont + ". Portico", "Frederik pohl", 534, 2.6f, R.drawable.escritor3));
            cont++;
            libros.add(new Libros(cont + ". La Fundacion", "Isaac Asimov", 654, 1.7f, R.drawable.escritor4));
            cont++;
            libros.add(new Libros(cont + ". Farenheit 451", "Ray Bradbury", 126, 3.4f, R.drawable.escritor5));
            cont++;
            libros.add(new Libros(cont + ". Cita con rama", "Arthur c. clarke", 464, 2.3f, R.drawable.escritor6));
            cont++;
            libros.add(new Libros(cont + ". 20000 lenguas", "Julio Verne", 234, 2.2f, R.drawable.escritor7));
            cont++;
            libros.add(new Libros(cont + ". Dune", "Frank Herbert", 129, 5f, R.drawable.escritor8));
            cont++;
            libros.add(new Libros(cont + ". Rayuela", "Julio Cortazar", 454, 3f, R.drawable.escritor9));

        }
        rv = findViewById(R.id.recyView);
        Adaptador adaptador = new Adaptador(libros, rv);
        GridLayoutManager gy = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gy);
        rv.setAdapter(adaptador);

        View.OnClickListener pulsador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rv.getChildAdapterPosition(v);
                Toast.makeText(MainActivity.this, libros.get(pos).getNombre(), Toast.LENGTH_SHORT).show();

            }
        };

        adaptador.setListener(pulsador);

    }


}

