package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoFavoritos extends AppCompatActivity {
ArrayAdapter<String> adapter;
ArrayList<String> titulosFav=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_favoritos);
        final ListView lvFavs = findViewById(R.id.lvFavs);

        Button btnApplicarFavs = findViewById(R.id.btnApplicarFavs);

        lvFavs.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        for (int i=0;i<MainActivity.pelis.size();i++){
            titulosFav.add(MainActivity.pelis.get(i).getTitulo());
        }

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,titulosFav);
        lvFavs.setAdapter(adapter);

        btnApplicarFavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < MainActivity.pelis.size(); i++) {
                    MainActivity.pelis.get(i).setFavorita(lvFavs.isItemChecked(i));
                }
            }
        });
for (int i=0;i<MainActivity.pelis.size();i++){
    lvFavs.setItemChecked(i,MainActivity.pelis.get(i).getFavorita());
}
    }


}