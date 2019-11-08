package com.example.t3_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class CambioHora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_hora);
        final TimePicker tmPicker = findViewById(R.id.timePicker);
        Button btn7 = findViewById(R.id.button7);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos = new Intent();
                datos.putExtra("HORA", tmPicker.getHour());
                datos.putExtra("MINUTO", tmPicker.getMinute());
                setResult(RESULT_OK, datos);
                finish();
            }
        });
    }
}
