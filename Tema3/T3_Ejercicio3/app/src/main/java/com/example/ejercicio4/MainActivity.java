package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton tgBtn = findViewById(R.id.toggleButton);
        final CheckBox chkBox1 = findViewById(R.id.checkBox1);
        final CheckBox chkBox2 = findViewById(R.id.checkBox2);
        final CheckBox chkBox3 = findViewById(R.id.checkBox3);
        final SeekBar seekB = findViewById(R.id.seekBar);
        final TextView txtSeekBN = findViewById(R.id.txtSeekBarNumber);
        final Switch switch1 = findViewById(R.id.switch1);
        final TextView txtSwitch = findViewById(R.id.txtSwitch);
        final Button btn1 = findViewById(R.id.button1);
        final RatingBar rtnB = findViewById(R.id.ratingBar);
        final EditText txtName = findViewById(R.id.editText);
        final ImageButton imgBtn = findViewById(R.id.imageButton);
        final TextView txtImgBtn = findViewById(R.id.txtImgBtn);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton rb1 = findViewById(R.id.radioButton);
        final RadioButton rb2 = findViewById(R.id.radioButton2);

        tgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgBtn.isChecked()) {
                    chkBox1.setChecked(true);
                } else {
                    chkBox1.setChecked(false);
                }
            }
        });

        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int seekValue = seekB.getProgress();
                String x = Integer.toString(seekValue);
                txtSeekBN.setText(x);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch1.isChecked()) {
                    txtSwitch.setText(getText(R.string.ButtonOn));
                } else {
                    txtSwitch.setText(getText(R.string.ButtonOff));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tgBtn.setChecked(false);
                chkBox1.setChecked(false);
                chkBox2.setChecked(false);
                chkBox3.setChecked(false);
                switch1.setChecked(false);
                seekB.setProgress(0);
                rtnB.setRating(0);
                txtName.setText("");
            }
        });
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkBox2.isChecked()) {
                    i--;
                } else {
                    i++;
                }
                txtImgBtn.setText("" + i);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        Toast.makeText(MainActivity.this, "RadioButton1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this, "RadioButton2", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}
