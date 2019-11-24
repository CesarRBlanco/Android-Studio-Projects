package com.example.mymovielist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class NuevaPelicula extends AppCompatActivity {

    String titulo;
    String director;
    int duracion;
    String sala;
    String[] salas;
    int clasi;
    Date fecha;
    int portada;

    EditText editTxtTitulo;
    EditText editTxtDirector;
    EditText editTxtDuracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_pelicula);
        TextView txtNuevoTitulo = findViewById(R.id.txtTituloNuevaPeli);
        TextView txtNuevoDirector = findViewById(R.id.txtNuevoDirector);
        TextView txtNuevoDuracion = findViewById(R.id.txtTituloNuevoDuracion);
        editTxtTitulo = findViewById(R.id.editTxtTitulo);
        editTxtDirector = findViewById(R.id.editTxtDirector);
        editTxtDuracion = findViewById(R.id.editTxtDuracion);
        Spinner spinner = findViewById(R.id.spinner);
        Button btnFecha = findViewById(R.id.btnNuevaFecha);
        RadioGroup btnRadios = findViewById(R.id.radioGroup);


        salas = new String[]{"Gran Via", "Travesia","Plaza Elíptica","Cines Norte"};
        
        clasi = R.drawable.g;
        duracion=0;
        portada = R.drawable.nocover;


        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FechaDialog dFecha = new FechaDialog();
                dFecha.show(getSupportFragmentManager(), "Fecha");
            }
        });
        
        btnRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        clasi = R.drawable.g;
                        break;
                    case R.id.radioButton2:
                        clasi = R.drawable.pg;
                        break;
                    case R.id.radioButton3:
                        clasi = R.drawable.pg13;
                        break;
                    case R.id.radioButton4:
                        clasi = R.drawable.nc17;
                        break;
                    case R.id.radioButton5:
                        clasi = R.drawable.r;
                        break;
                }
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, salas);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sala = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nuevapeli, menu);
        return true;
    }


    Calendar cal;

    public void fecha(int año, int mes, int dia) {
        cal = Calendar.getInstance();
        cal.set(año, mes, dia);
        fecha = cal.getTime();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.añadirPeli:
                titulo = editTxtTitulo.getText().toString();
                director = editTxtDirector.getText().toString();
                duracion = Integer.parseInt(editTxtDuracion.getText().toString());

                if (fecha == null||titulo.equals("")||director.equals("")||duracion==0) {
                    Toast.makeText(this, "Todos los campos deben ser rellenados", Toast.LENGTH_SHORT).show();
                    break;
                }
                MainActivity.pelis.add(new Pelicula(titulo, director, duracion, fecha, sala, clasi, portada));

                finish();
                break;
            case R.id.cancelarPeli:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

