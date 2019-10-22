package com.example.t3_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tercera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        Button btnCall = findViewById(R.id.button3);
        final EditText txtPhone = findViewById(R.id.editText3);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                if (intent3.resolveActivity(getPackageManager()) != null) {
                    intent3.setData(Uri.parse("tel:" + txtPhone.getText().toString()));
                    startActivity(intent3);
                }
            }
        });

    }
}

