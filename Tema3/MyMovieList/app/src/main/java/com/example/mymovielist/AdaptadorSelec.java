package com.example.mymovielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorSelec  extends RecyclerView.Adapter<AdaptadorSelec.Elemento> implements View.OnClickListener

{

    ArrayList<Pelicula> pelis;
    View.OnClickListener listener;
    RecyclerView rv;


    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public AdaptadorSelec(ArrayList<Pelicula> pelis, RecyclerView rv) {
        this.rv = rv;
        this.pelis = pelis;
    }


    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    @Override
    public int getItemCount() {
        return pelis.size();
    }

    public static class Elemento extends RecyclerView.ViewHolder {
        TextView titulo, director, fecha,duracion,sala;
        ImageView portada, rateEdad;


        public Elemento(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.txtTituloSelec);
            this.director = itemView.findViewById(R.id.txtDirectorSelec);
            this.portada = itemView.findViewById(R.id.imgPortadaSelec);
            this.portada = itemView.findViewById(R.id.imgPortadaSelec);
            this.duracion= itemView.findViewById(R.id.txtDuracionSelec);
            this.sala=itemView.findViewById(R.id.txtSalaSelec);
        }
    }

    @NonNull
    @Override
    public AdaptadorSelec.Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_items_selec, parent, false);
        lista.setOnClickListener(this);
        AdaptadorSelec.Elemento ele = new AdaptadorSelec.Elemento(lista);
        return ele;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorSelec.Elemento holder, int position) {
        Pelicula p = pelis.get(position);

        String tituloL=p.getTitulo();
        String tituloS;
        if(tituloL.length()>30){

            tituloS=tituloL.substring(0,30);
            tituloS=tituloS+"...";
        }else{
            tituloS=tituloL;
        }

        holder.titulo.setText(tituloS);
holder.duracion.setText(p.getDuracionFormat());
        holder.director.setText(p.getDirector());
        holder.portada.setImageResource(p.getPortada());
        holder.sala.setText(p.getSala());
    }

}




