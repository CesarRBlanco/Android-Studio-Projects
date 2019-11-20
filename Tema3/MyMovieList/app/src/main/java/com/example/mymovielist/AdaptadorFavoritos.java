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

    // Devuelve el elemento asociado con la posición en el ListView
    @Override
    public Object getItem(int position) {
        return pelisFav.get(position);
    }

    // A partir de la posición en la ListView da la posición en el arraylist
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Sobrescribimos el método getView() de nuestro Adapter para utilizar el Contenedor
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Contenedor contenedor = null; // Aquí se gestionan las filas
        /* Si la vista ya existe en pantalla no se crea otra si no que se reutiliza la que hay.
         * Así si es null significa que hay que crearla, si no es null, se coge una existente */
        if (view == null) {
// "Inflamos" la vista
            view = inflador.inflate(R.layout.listview_items_favoritos, null);
            // Creamos el contenedor e instanciamos los recursos
            contenedor = new Contenedor();
            contenedor.txtTituloFav = view.findViewById(R.id.txtTituloFav);
            contenedor.chkFavs = view.findViewById(R.id.chkFav);
// Asignamos el Contenedor a la vista
            view.setTag(contenedor);
        } else contenedor = (Contenedor) view.getTag(); // obtengo el contenedor
// Obtenemos el dato a mostrar y lo colocamos en los componentes
        Pelicula p = (Pelicula) getItem(position);
        contenedor.txtTituloFav.setText(p.getTitulo());

        return view;
    }


    // Clase para gestionar los componentes de la fila
    class Contenedor {

        TextView txtTituloFav;
        CheckBox chkFavs;
    }
}
