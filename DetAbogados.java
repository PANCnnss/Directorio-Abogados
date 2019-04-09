package com.example.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;


public class DetAbogados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det_abogados);

        TextView Nombre = (TextView) findViewById(R.id.txtNombre);
        TextView Rama = (TextView) findViewById(R.id.txtRama);
        TextView Ciudad = (TextView) findViewById(R.id.txtCiudad);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {

            Nombre.setText(b.getString("Nombre"));
            Rama.setText(b.getString("Rama"));
            Ciudad.setText(b.getString("Ciudad"));
        }
    }
}
