package com.example.tema3_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datos;
    ListView lv;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datos.add(i + "file");
        }

        lv = findViewById(R.id.lstView);
        adaptador = new ArrayAdapter<>(this, android.R.layout.select_dialog_multichoice, datos);
        lv.setAdapter(adaptador);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch
        (item.getItemId()){
            case R.id.add:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
        datos.add(0,"nuevo");
        adaptador.notifyDataSetChanged();
        return true;
            case R.id.del:

                for (int i=lv.getCount()-1;i>=0;i--){
                    if(lv.isItemChecked(i)){
                        datos.remove(i);
                    }
                }
                lv.getCheckedItemPositions().clear();
                adaptador.notifyDataSetChanged();



        return true;
        }
        return super.onOptionsItemSelected(item);
    }

}