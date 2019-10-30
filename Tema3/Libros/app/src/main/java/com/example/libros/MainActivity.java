package com.example.libros;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Libros> libros;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libros = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            libros.add(new Libros(i+". Sueñan?", "Philip k dick", 123, 4.4f, R.drawable.escritor1));
            libros.add(new Libros(i+". Mundo anillo", "Larry niven", 234, 2.4f, R.drawable.escritor2));
            libros.add(new Libros(i+". Portico", "Frederik pohl", 534, 2.6f, R.drawable.escritor3));
            libros.add(new Libros(i+". La Fundacion", "Isaac Asimov", 654, 1.7f, R.drawable.escritor4));
            libros.add(new Libros(i+". Farenheit 451", "Ray Bradbury", 126, 3.4f, R.drawable.escritor5));
            libros.add(new Libros(i+". Cita con rama", "Arthur c. clarke", 464, 2.3f, R.drawable.escritor6));
            libros.add(new Libros(i+". 20000 lenguas", "Julio Verne", 234, 2.2f, R.drawable.escritor7));
            libros.add(new Libros(i+". Dune", "Frank Herbert", 129, 5f, R.drawable.escritor8));
            libros.add(new Libros(i+". Rayuela", "Julio Cortazar", 454, 3f, R.drawable.escritor9));

        }
        rv = findViewById(R.id.recyView);
        Adaptador adaptador=new Adaptador(libros);
        GridLayoutManager gy=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gy);
        rv.setAdapter(adaptador);
    }


}

