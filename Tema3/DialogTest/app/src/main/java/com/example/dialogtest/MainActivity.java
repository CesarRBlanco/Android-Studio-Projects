package com.example.dialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btndialog=findViewById(R.id.button);
        Button btndate=findViewById(R.id.button2);
        Button btndtime=findViewById(R.id.button3);

        btndialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogo dialogo=new Dialogo();
                dialogo.show(getSupportFragmentManager(),"TAGUNICO");
            }
        });


    btndate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogoCal dialogoCal=new DialogoCal();
            dialogoCal.show(getSupportFragmentManager(),"TAG_CAL");
        }
    });
    }


    public void setText(String cad){

    }
}
