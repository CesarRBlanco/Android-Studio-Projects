package com.example.tema3_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SistemaOperativo> sistemas;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sistemas = new ArrayList<SistemaOperativo>();
        for (int i = 1; i <= 9; i++) {
            sistemas.add(new SistemaOperativo(i + " Ubuntu 14.04", "2014", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i + " MacOS X Tiger", "2004", R.drawable.apple));
            sistemas.add(new SistemaOperativo(i + " Windows 95", "1995", R.drawable.windows));
            sistemas.add(new SistemaOperativo(i + " Debian", "1993", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i + " Linux Mint 15", "2013", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i + " Windows 10", "2016", R.drawable.windows));
            sistemas.add(new SistemaOperativo(i + " Android", "2006", R.drawable.android));
            sistemas.add(new SistemaOperativo(i + " iOS 8", "2014", R.drawable.apple));
            sistemas.add(new SistemaOperativo(i + " Windows XP", "2001", R.drawable.windows));
            sistemas.add(new SistemaOperativo(i + " Elementary OS", "2014", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i + " MacOS 9", "1999", R.drawable.apple));
            sistemas.add(new SistemaOperativo(i + " Ubuntu 14.04", "2014", R.drawable.tux));
        }
        rv = findViewById(R.id.recicleiew);
        LinearLayoutManager ly = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(ly);
        Adaptador adaptador = new Adaptador(sistemas);
        rv.setAdapter(adaptador);
    }
}