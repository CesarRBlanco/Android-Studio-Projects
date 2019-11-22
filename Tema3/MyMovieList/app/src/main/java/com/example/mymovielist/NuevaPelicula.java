package com.example.mymovielist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

import java.util.Date;

public class NuevaPelicula extends AppCompatActivity {

    TextView txtNuevoTitulo=findViewById(R.id.txtTituloNuevaPeli);
    TextView txtNuevoDirector=findViewById(R.id.txtNuevoDirector);
    TextView txtNuevoDuracion=findViewById(R.id.txtTituloNuevoDuracion);
    EditText editTxtTitulo=findViewById(R.id.editTxtTitulo);
    EditText editTxtDirector=findViewById(R.id.editTxtDirector);
    EditText editTxtDuracion=findViewById(R.id.editTxtDuracion);
    Spinner spinner=findViewById(R.id.spinner);
    Button btnFecha=findViewById(R.id.btnNuevaFecha);
RadioGroup btnRadios=findViewById(R.id.radioGroup);


    final    String titulo=editTxtTitulo.getText().toString();
    String director=editTxtDirector.getText().toString();
    int duracion= editTxtDuracion.getText();
    String sala;
    String[] salas={"Ge","as"};
    int clasi;
    Date fecha;
    int portada=R.drawable.akira;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_pelicula);



        btnRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        clasi=R.drawable.g;
                        break;

                }
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,salas);
        spinner.setAdapter(adapter);

  spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          sala=parent.getItemAtPosition(position).toString();      }
  });



            }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.nuevapeli, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.añadirPeli:

                    MainActivity.pelis.add(new Pelicula(titulo,director,duracion,fecha,sala,clasi,portada));
                    break;
                case R.id.favs:

                    break;
                default:
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

    }

