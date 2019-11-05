package com.example.t3_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int MIREQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editName = findViewById(R.id.editText);
        Button btnThird = findViewById(R.id.button2);
        Button btnSend = findViewById(R.id.button);
        Button btnFecha = findViewById(R.id.button4);
        Button btnHora = findViewById(R.id.button5);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Secundaria.class);
                intent.putExtra("NAME", editName.getText().toString());

                startActivityForResult(intent, MIREQUESTCODE);
            }
        });

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentT = new Intent(MainActivity.this, Tercera.class);
                startActivity(intentT);
            }
        });

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intetFecha = new Intent(MainActivity.this, CambioFecha.class);
                startActivityForResult(intetFecha, MIREQUESTCODE);

            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intetHora = new Intent(MainActivity.this, CambioHora.class);
                startActivityForResult(intetHora, MIREQUESTCODE);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String todayFeels = "Hoy te sientes ";
        final TextView txt = findViewById(R.id.txtView);
        final TextView txtFech = findViewById(R.id.txtFecha);
        Bundle datosI = getIntent().getExtras();


        if (requestCode == MIREQUESTCODE && resultCode == RESULT_OK) {

            txtFech.setText(datosI.getInt("y"));


//            switch ((int) data.getFloatExtra("ESTADO", 0f)) {
//                case 0:
//                    txt.setText(todayFeels + "por los suelos");
//                    break;
//                case 1:
//                    txt.setText(todayFeels + "de bajón");
//                    break;
//                case 2:
//                    txt.setText(todayFeels + "triste");
//                    break;
//                case 3:
//                    txt.setText(todayFeels + "normal");
//                    break;
//                case 4:
//                    txt.setText(todayFeels + "contento");
//                    break;
//                case 5:
//                    txt.setText(todayFeels + "feliz");
//                    break;
//            }
        }

    }

}
