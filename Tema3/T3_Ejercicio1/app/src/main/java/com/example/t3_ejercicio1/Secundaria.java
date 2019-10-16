package com.example.t3_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Intent ite=getIntent();
        final TextView nombre=findViewById(R.id.textViewMensaje);
        nombre.setText(("Hello "+ite.getStringExtra("NAME")));
    }
}
