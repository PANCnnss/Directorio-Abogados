package com.example.principal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    Spinner ramas;
    Spinner calificacion;
    Spinner ciudades;
    ListView lista;
    String [][] datos={
            {"Juan", "5","Derecho Penal", "Lima"},
            {"Maria", "4","Derecho civil", "Puno"},
            {"Beatriz", "6","Derecho familiar", "Cusco"},
            {"Jose", "7","Derecho mercantil", "Arequipa"}
    };
    String[]ciudad={
            "Amazonas","Áncash","Apurímac", "Arequipa","Ayacucho", "Cajamarca","Cusco",
            "Huancavelica", "Huánuco","Ica","Junín","La Libertad", "Lambayeque","Lima",
            "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martín",
            "Tacna", "Tumbes", "Ucayali"
    };

    String[] rama={
            "Derecho administrativo", "Derecho  civil", "Derecho de familia", "Derecho laboral ","Derecho mercantil","Derecho penal"};
    int[] datosImg ={R.drawable.juan, R.drawable.maria, R.drawable.beatriz,R.drawable.jose};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String>  adapterc=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,ciudad);
        AutoCompleteTextView textView =(AutoCompleteTextView)
            findViewById(R.id.ctxtCiudades);
        textView.setThreshold(3);
        textView.setAdapter(adapterc);

        ArrayAdapter<String>  adapterr=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,rama);
        AutoCompleteTextView textView2 =(AutoCompleteTextView)
                findViewById(R.id.ctxtRamas);
        textView2.setThreshold(4);
        textView2.setAdapter(adapterr);

        calificacion =(Spinner) findViewById(R.id.spcalificacion);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.calificacion, R.layout.spinner_item_enchular);
        calificacion.setAdapter(adapter2);

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
