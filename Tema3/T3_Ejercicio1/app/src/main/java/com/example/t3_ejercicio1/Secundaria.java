package com.example.t3_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    final RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Intent ite=getIntent();
        final TextView nombre=findViewById(R.id.textViewMensaje);
        nombre.setText(("Hello "+ite.getStringExtra("NAME")));
        final Button btnVolver=(Button)findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSec=new Intent();
                intentSec.putExtra("ESTADO", ratingBar.getRating());
                setResult(RESULT_OK, intentSec);
                finish();
            }
        });
    }

}
