package com.example.test_orientacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPage);


        Adaptador adaptador = new Adaptador(getSupportFragmentManager());
        a fa = new a();
        b fb = new b();
        c fc = new c();
        adaptador.inserta(fa, "AAA");
        adaptador.inserta(fb, "BBB");
        adaptador.inserta(fc, "CCC");

        viewPager.setAdapter(adaptador);
        tabLayout.setupWithViewPager(viewPager);


    tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_lock_lock);
    tabLayout.getTabAt(1).setIcon(android.R.drawable.btn_star);
    }


}
