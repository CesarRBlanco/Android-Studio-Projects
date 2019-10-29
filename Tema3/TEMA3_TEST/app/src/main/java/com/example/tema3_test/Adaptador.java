package com.example.tema3_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyHolder> {

    ArrayList<SistemaOperativo> sistemas;

    public Adaptador(ArrayList<SistemaOperativo> sistemas) {
        this.sistemas = sistemas;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent, false
        );

        MyHolder my = new MyHolder(vista);
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SistemaOperativo so = sistemas.get(position);
        holder.logo.setImageResource(so.getLogo());
        holder.nombre.setText(so.getNombre());
        holder.year.setText(so.getYear());
    }

    @Override
    public int getItemCount() {
        return sistemas.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView nombre, year;
        ImageView logo;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.textViewName);
            this.year = itemView.findViewById(R.id.textViewYear);
            this.logo = itemView.findViewById(R.id.imageView);

        }
    }
}
