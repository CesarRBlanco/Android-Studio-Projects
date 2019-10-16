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
    int MIREQUESTCODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editName=findViewById(R.id.editText);

        Button btnSend=findViewById(R.id.button);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent=new Intent(MainActivity.this, Secundaria.class);
                intent.putExtra("NAME", editName.getText().toString());

                startActivityForResult(intent, MIREQUESTCODE);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final TextView txt =findViewById(R.id.txtView);
        if (requestCode == MIREQUESTCODE && resultCode == RESULT_OK){
            switch((int)data.getFloatExtra("ESTADO", 0f)){
                case 0:
                    txt.setText("Por los suelos"); break;
                case 1:
                    txt.setText("De bajón"); break;
                case 2:
                    txt.setText("Triste"); break;
                case 3:
                    txt.setText("Normal"); break;
                case 4:
                    txt.setText("Contento"); break;
                case 5:
                    txt.setText("Feliz"); break;
            }
        }
    }

}
