package com.example.libros;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Elemento> implements View.OnClickListener {
    ArrayList<Libros> libros;
    View.OnClickListener listener;
    int posPulasdo = -1;
    RecyclerView rv;


    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public Adaptador(ArrayList<Libros> libros, RecyclerView rv) {
        this.rv = rv;
        this.libros = libros;
    }


    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
        int aux = this.posPulasdo;
        this.posPulasdo = rv.getChildAdapterPosition(v);
        if (aux == this.posPulasdo) {
            posPulasdo = -1;
            notifyItemChanged(aux);
        } else {

            notifyItemChanged(this.posPulasdo);
            if (aux > -1) notifyItemChanged(aux);

        }
    }

    public static class Elemento extends RecyclerView.ViewHolder {
        TextView titulo, autor, paginas;
        RatingBar valoracion;
        ImageView portada;

        public Elemento(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.txtNombre);
            this.autor = itemView.findViewById(R.id.txtAutor);
            this.paginas = itemView.findViewById(R.id.txtPaginas);
            this.valoracion = itemView.findViewById(R.id.ratingBar);
            this.portada = itemView.findViewById(R.id.imageView);

        }
    }

    @NonNull
    @Override
    public Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.posicion, parent, false);
        celda.setOnClickListener(this);
        Elemento ele = new Elemento(celda);
        return ele;
    }

    @Override
    public void onBindViewHolder(@NonNull Elemento holder, int position) {
        Libros l = libros.get(position);
        holder.titulo.setText(l.getNombre());
        holder.autor.setText(l.getAutor());
        holder.paginas.setText(String.valueOf(l.getNumPaginas()));
        holder.valoracion.setRating(l.getValoracion());
        holder.portada.setImageResource(l.getPortada());
        if (position == this.posPulasdo)
            holder.itemView.findViewById(R.id.txtNombre).setBackgroundResource(R.color.pulsado);
        else holder.itemView.findViewById(R.id.txtNombre).setBackgroundResource(R.color.nopulsado);
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }
}

