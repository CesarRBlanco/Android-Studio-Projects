package com.example.mymovielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Elemento> implements View.OnClickListener {

    ArrayList<Pelicula> pelis;
    View.OnClickListener listener;
    RecyclerView rv;


    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public Adaptador(ArrayList<Pelicula> pelis, RecyclerView rv) {
        this.rv = rv;
        this.pelis = pelis;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public int getItemCount() {
        return pelis.size();
    }

    public static class Elemento extends RecyclerView.ViewHolder {
        TextView titulo, director, año;
        ImageView portada, rateEdad;

        public Elemento(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.txtTitulo);
            this.director = itemView.findViewById(R.id.txtDirector);
            this.año = itemView.findViewById(R.id.txtAño);
            this.portada = itemView.findViewById(R.id.imgPortada);
            this.rateEdad = itemView.findViewById(R.id.imgRate);

        }
    }

    @NonNull
    @Override
    public Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_items, parent, false);
        lista.setOnClickListener(this);
        Elemento ele = new Elemento(lista);
        return ele;
    }

    @Override
    public void onBindViewHolder(@NonNull Elemento holder, int position) {
        Pelicula p = pelis.get(position);
        holder.titulo.setText(p.getTitulo());
        holder.director.setText(p.getDirector());
        holder.año.setText(p.getFecha().toString());
        holder.rateEdad.setImageResource(p.getClasi());
        holder.portada.setImageResource(p.getPortada());
//        if (position == this.posPulasdo)
//            holder.itemView.findViewById(R.id.txtNombre).setBackgroundResource(R.color.pulsado);
//        else holder.itemView.findViewById(R.id.txtNombre).setBackgroundResource(R.color.nopulsado);
    }

}
