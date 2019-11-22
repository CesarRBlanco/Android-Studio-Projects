package com.example.mymovielist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorListado extends RecyclerView.Adapter<AdaptadorListado.ElementoListado> implements View.OnClickListener {

    ArrayList<Pelicula> peliculasCompletas;
    View.OnClickListener listenerCompleto;
    RecyclerView rvCompleto;


    public void setListener(View.OnClickListener listenerCompleto) {
        this.listenerCompleto = listenerCompleto;
    }


    public AdaptadorListado(ArrayList<Pelicula> peliculasCompletas, RecyclerView rvCompleto) {
        this.rvCompleto = rvCompleto;
        this.peliculasCompletas = peliculasCompletas;
    }

    @Override
    public void onClick(View v) {
        if (this.listenerCompleto != null) {
            listenerCompleto.onClick(v);
        }
    }

    @NonNull
    @Override
    public ElementoListado onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_items_completos, parent, false);
        lista.setOnClickListener(this);
        ElementoListado lListado = new ElementoListado(lista);
        return lListado;
    }

    @Override
    public void onBindViewHolder(@NonNull ElementoListado holder, int position) {
        Pelicula p = peliculasCompletas.get(position);
        String tituloL = p.getTitulo();
        String tituloS;
        if (tituloL.length() > 12) {
            tituloS = tituloL.substring(0, 12);
            tituloS = tituloS + "...";
        } else {
            tituloS = tituloL;
        }
        holder.titulo.setText(tituloS);
        holder.director.setText(p.getDirector());
        holder.año.setText(p.getFechaFormat());
        holder.duracion.setText(p.getDuracionFormat());
        holder.sala.setText(p.getSala());
        holder.rateEdad.setImageResource(p.getClasi());
        holder.portada.setImageResource(p.getPortada());
        holder.favorita.setClickable(false);
        holder.favorita.setChecked(MainActivity.pelis.get(position).getFavorita());
    }

    @Override
    public int getItemCount() {
        return peliculasCompletas.size();
    }

    public class ElementoListado extends RecyclerView.ViewHolder {
        TextView titulo, director, año, duracion, sala;
        ImageView portada, rateEdad;
        CheckBox favorita;

        public ElementoListado(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.txtTituloCompleto);
            this.director = itemView.findViewById(R.id.txtDirectorCompleto);
            this.portada = itemView.findViewById(R.id.imgPortadaCompleto);
            this.rateEdad = itemView.findViewById(R.id.imgRateCompleto);
            this.año = itemView.findViewById(R.id.txtFechaCompleto);
            this.duracion = itemView.findViewById(R.id.txtDuracionCompleto);
            this.sala = itemView.findViewById(R.id.txtSalaCompleto);
            this.favorita=itemView.findViewById(R.id.checkBox);


        }
    }
}
