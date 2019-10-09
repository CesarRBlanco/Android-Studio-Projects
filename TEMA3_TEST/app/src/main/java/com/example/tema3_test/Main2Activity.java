package com.example.tema3_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("dasd");
        Button btnVolver=findViewById(R.id.button2);
        TextView txtV=findViewById(R.id.textView);
        final RatingBar rb=findViewById(R.id.ratingBar);
        Intent ite=getIntent();
        txtV.setText(ite.getStringExtra("TEXTO"));
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent it2=new Intent(Main2Activity.this,MainActivity.class);
           it2.putExtra("RATING",rb.getRating());
            startActivity(it2);
            }
        });
    }
}
