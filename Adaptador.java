package com.example.principal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;

    public Adaptador(Context conexto, String[][] datos, int[] imagenes)
    {
        this.contexto = conexto;
        this.datos = datos;
        this.datosImg = imagenes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView nombre = (TextView) vista.findViewById(R.id.txtNombre);
        TextView rama = (TextView) vista.findViewById(R.id.txtRama);
        TextView ciudad = (TextView) vista.findViewById(R.id.txtCiudad);

        ImageView imagen = (ImageView) vista.findViewById(R.id.ivAbogado);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.rbCalificacion);

        nombre.setText(datos[i][0]);
        rama.setText(datos[i][2]);
        ciudad.setText(datos[i][3]);
        imagen.setImageResource(datosImg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][1]));


        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
