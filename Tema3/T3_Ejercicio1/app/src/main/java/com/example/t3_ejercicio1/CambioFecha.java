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
int ny=0, nd=0,nm=0;
    DatePicker datePick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_fecha);

//    int año=1999,mes=12,dia=13;
         datePick=findViewById(R.id.datePick);
//
//        datePick.init(año, mes, dia, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//            }
//        });


        Button b=findViewById(R.id.button6);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ny==0) {
//                    Toast.makeText(CambioFecha.this, "Selecciona fecha", Toast.LENGTH_SHORT).show();
//                }else {
                    Intent datos=new Intent();
                    datos.putExtra("y",datePick.getYear());
                    datos.putExtra("m",datePick.getMonth());
                    datos.putExtra("d",datePick.getDayOfMonth());
                    setResult(RESULT_OK, datos);
                    finish();
//                }
            }
        });

    }


}
