package com.example.mymovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PeliculaInfo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_info);

        final PeliculasRepository lanzarYT = new PeliculasRepository();
        final String IdYT;

        TextView txtSipnosis = findViewById(R.id.txtSipnosis);
        ImageView imgPortadaInfo = findViewById(R.id.imgPortadaInfo);
        Intent intentInfo = getIntent();
        IdYT = intentInfo.getStringExtra("YoutubeId");
        this.setTitle(intentInfo.getStringExtra("Titulo"));
        txtSipnosis.setText(intentInfo.getStringExtra("Sipnosis"));
        imgPortadaInfo.setImageResource(intentInfo.getIntExtra("Portada", 0));


        imgPortadaInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Toast.makeText(PeliculaInfo.this, IdYT, Toast.LENGTH_SHORT).show();
//                lanzarYT.watchYoutubeVideo(IdYT);

                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + IdYT));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + IdYT));
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });
    }
}
