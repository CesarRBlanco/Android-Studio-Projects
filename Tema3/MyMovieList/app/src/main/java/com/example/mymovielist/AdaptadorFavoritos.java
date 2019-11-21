package com.example.mymovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorFavoritos extends BaseAdapter {
    ArrayList<Pelicula> pelisFav;
    LayoutInflater inflador;

    public AdaptadorFavoritos(Context contexto, ArrayList<Pelicula> lista) {
        this.inflador = LayoutInflater.from(contexto);
        this.pelisFav = lista;
    }

    public int getCount() {
        return pelisFav.size();
    }

    @Override
    public Object getItem(int position) {
        return pelisFav.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Contenedor contenedor = null;
        if (view == null) {
            view = inflador.inflate(R.layout.listview_items_favoritos, null);
            contenedor = new Contenedor();
            contenedor.txtTituloFav = view.findViewById(R.id.txtTituloFav);
            contenedor.chkFavs = view.findViewById(R.id.chkFav);
            view.setTag(contenedor);
        } else contenedor = (Contenedor) view.getTag();
        Pelicula p = (Pelicula) getItem(position);
        contenedor.txtTituloFav.setText(p.getTitulo());
        contenedor.chkFavs.setChecked(p.getFavorita());

        return view;
    }

    public void changeCheck(int position,boolean state){
        Pelicula p=(Pelicula) getItem(position);
        p.setFavorita(state);
    }

    class Contenedor {

        TextView txtTituloFav;
        CheckBox chkFavs;
    }
}
