package com.example.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    Spinner ramas;
    Spinner calificacion;
    Spinner ciudades;
    ListView lista;
    String [][] datos={
            {"Juan", "5","Derecho Penal", "Lima"},
            {"Maria", "4","Derecho administrativo", "Puno"},
            {"Beatriz", "6","Derecho familiar", "Cusco"},
            {"Jose", "7","Derecho administrativo", "Arequipa"}
    };
    int[] datosImg ={R.drawable.juan, R.drawable.maria, R.drawable.beatriz,R.drawable.jose};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ramas =(Spinner) findViewById(R.id.spramas);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.ramas, android.R.layout.simple_spinner_item);
        ramas.setAdapter(adapter);

        calificacion =(Spinner) findViewById(R.id.spcalificacion);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.calificacion, android.R.layout.simple_spinner_item);
        calificacion.setAdapter(adapter2);

        ciudades =(Spinner) findViewById(R.id.spciudad);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        ciudades.setAdapter(adapter3);


        lista=(ListView) findViewById(R.id.lvabogados);
        lista.setAdapter(new Adaptador(this,datos, datosImg));


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles =new Intent(view.getContext(), DetAbogados.class);
                visorDetalles.putExtra("Nombre", datos[position][0]);
                visorDetalles.putExtra("Rama", datos[position][2]);
                visorDetalles.putExtra("Ciudad",datos[position][3]);
                startActivity(visorDetalles);
            }
        });
    }
}
