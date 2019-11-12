package com.example.t3_ejercicioadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AdaptadorSistemas extends BaseAdapter  {
    ArrayList<SistemaOperativo> lista;
    LayoutInflater inflador;



    public AdaptadorSistemas(Context contexto, ArrayList<SistemaOperativo> lista) {
        this.inflador = LayoutInflater.from(contexto);
        this.lista = lista;
    }



    @Override
    public int getCount() {
        return lista.size();
    }

    // Devuelve el elemento asociado con la posición en el ListView
    @Override
    public Object getItem(int position) {
        return lista.get(position);
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
            view = inflador.inflate(R.layout.fila, null);
            // Creamos el contenedor e instanciamos los recursos
            contenedor = new Contenedor();
            contenedor.logotipo = (ImageView) view.findViewById(R.id.logo);
            contenedor.txtSistema = (TextView) view.findViewById(R.id.txtSistema);
            contenedor.txtAno = (TextView) view.findViewById(R.id.txtFecha);
// Asignamos el Contenedor a la vista
            view.setTag(contenedor);
        } else contenedor = (Contenedor) view.getTag(); // obtengo el contenedor
// Obtenemos el dato a mostrar y lo colocamos en los componentes
        SistemaOperativo so = (SistemaOperativo) getItem(position);
        contenedor.logotipo.setImageResource(so.getLogo());
        contenedor.txtSistema.setText(so.getNombre());
        contenedor.txtAno.setText(so.getAno());

        if (position%2==0)view.setBackgroundResource(R.color.colorAccent);
        else view.setBackgroundColor(Color.parseColor("#ff0000"));
        return view;
    }



    // Clase para gestionar los componentes de la fila
    class Contenedor {
        ImageView logotipo;
        TextView txtSistema, txtAno;
    }


}