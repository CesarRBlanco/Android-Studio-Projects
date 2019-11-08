package com.example.t3_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import javax.xml.transform.Result;

public class CambioFecha extends AppCompatActivity {
    DatePicker datePick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_fecha);
        datePick = findViewById(R.id.datePick);
        Button b = findViewById(R.id.button6);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos = new Intent();
                datos.putExtra("YEAR", datePick.getYear());
                datos.putExtra("MONTH", datePick.getMonth());
                datos.putExtra("DAY", datePick.getDayOfMonth());
                setResult(RESULT_OK, datos);
                finish();
//                }
            }
        });

    }


}
