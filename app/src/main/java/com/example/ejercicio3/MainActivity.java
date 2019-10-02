package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton tgb=findViewById(R.id.toggleButton);
        final CheckBox ckb1=findViewById(R.id.checkBox);
        final SeekBar seek =findViewById(R.id.seekBar);
        final TextView txtSeek=findViewById(R.id.textView4);
        tgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgb.isChecked()){
                    ckb1.setChecked(true);
                }else{
                    ckb1.setChecked(false);
                }
            }
        });


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            int seekValue = seek.getProgress();
            String x = Integer.toString(seekValue);
            txtSeek.setText(x);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
