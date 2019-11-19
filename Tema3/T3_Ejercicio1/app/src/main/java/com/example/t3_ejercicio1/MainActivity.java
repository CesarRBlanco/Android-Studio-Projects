package com.example.t3_ejercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int MIREQUESTCODE = 1;
    int MIREQUESTCODEF = 2;
    int MIREQUESTCODEH = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
String cadena="Hola mundo";
String subCadena=cadena.substring(0,4);

TextView prueba=findViewById(R.id.txtPrueba);
prueba.setText(subCadena);
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
                startActivityForResult(intetFecha, MIREQUESTCODEF);

            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intetHora = new Intent(MainActivity.this, CambioHora.class);
                startActivityForResult(intetHora, MIREQUESTCODEH);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String todayFeels = "Hoy te sientes ";
        final TextView txt = findViewById(R.id.txtView);
        final TextView txtFech = findViewById(R.id.txtFecha);
        final TextView txtHora = findViewById(R.id.txtHora);

        if (requestCode == MIREQUESTCODEF && resultCode == RESULT_OK) {
            int año = data.getIntExtra("YEAR", 0);
            int mes = data.getIntExtra("MONTH", 0);
            int dia = data.getIntExtra("DAY", 0);
        txtFech.setText(String.format("%d/%d/%d",dia,mes,año));
        }

        if (requestCode == MIREQUESTCODEH && resultCode == RESULT_OK) {
            int hora=data.getIntExtra("HORA",0);
        int minuto=data.getIntExtra("MINUTO",0);
        txtHora.setText(String.format("%d : %d",hora,minuto));
        }

        if (requestCode == MIREQUESTCODE && resultCode == RESULT_OK) {

            switch ((int) data.getFloatExtra("ESTADO", 0f)) {
                case 0:
                    txt.setText(todayFeels + "por los suelos");
                    break;
                case 1:
                    txt.setText(todayFeels + "de bajón");
                    break;
                case 2:
                    txt.setText(todayFeels + "triste");
                    break;
                case 3:
                    txt.setText(todayFeels + "normal");
                    break;
                case 4:
                    txt.setText(todayFeels + "contento");
                    break;
                case 5:
                    txt.setText(todayFeels + "feliz");
                    break;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.border,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nuevo2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            case R.id.nuevo3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            case R.id.borrar:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            case R.id.editar:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                default:
                return super.onOptionsItemSelected(item);
        }

    }
}
