package com.example.t3_ejercicioadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdaptadorSistemas adapter;
    ArrayList<SistemaOperativo> sistemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listview);

        sistemas = new ArrayList<SistemaOperativo>();
        sistemas.add(new SistemaOperativo("Ubuntu 14.04", "2014", R.drawable.tux));
        sistemas.add(new SistemaOperativo("MacOS X Tiger", "2004", R.drawable.apple));
        sistemas.add(new SistemaOperativo("Windows 95", "1995", R.drawable.windows));
        sistemas.add(new SistemaOperativo("Debian", "1993", R.drawable.tux));
        sistemas.add(new SistemaOperativo("Linux Mint 15", "2013", R.drawable.tux));
        sistemas.add(new SistemaOperativo("Windows 10", "2016", R.drawable.windows));
        sistemas.add(new SistemaOperativo("Android", "2006", R.drawable.android));
        sistemas.add(new SistemaOperativo("iOS 8", "2014", R.drawable.apple));
        sistemas.add(new SistemaOperativo("Windows XP", "2001", R.drawable.windows));
        sistemas.add(new SistemaOperativo("Elementary OS", "2014", R.drawable.tux));
        sistemas.add(new SistemaOperativo("MacOS 9", "1999", R.drawable.apple));
        adapter = new AdaptadorSistemas(this, sistemas);
        isWindows();

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SistemaOperativo so = (SistemaOperativo) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Borrada posición: " + position + " -> " + so.getNombre(),
                        Toast.LENGTH_SHORT).show();
                sistemas.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
            }

        });

    }
        public void isWindows () {
            for (int i = 0; i < sistemas.size(); i++) {
                if (sistemas.get(i).getNombre().contains("Windows")) {
                    sistemas.get(i).setLogo(0);
                }
            }

            adapter.notifyDataSetChanged();
        }

    }