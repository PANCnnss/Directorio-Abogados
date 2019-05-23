package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.myapplication.Clases.Abogado;
import com.example.myapplication.Clases.Utils;
import com.example.myapplication.Clases.V;


public class RegistroAbogados2 extends AppCompatActivity {

    Abogado abogado;
    TextInputLayout tirpr,tirse,tiidi,tines,tides,tidir,ticiu,tipag;
    MultiAutoCompleteTextView mtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_abogados2);
        tirpr= findViewById(R.id.tfrp);
        tirse= findViewById(R.id.tfrsec);
        tiidi = findViewById(R.id.tfidi);
        tines = findViewById(R.id.tfnes);
        tides = findViewById(R.id.tfdes);
        tidir = findViewById(R.id.tfdir);
        ticiu = findViewById(R.id.tfciu);
        tipag = findViewById(R.id.tfpag);
        Utils.assignOptionsAutoComplete(this,(AutoCompleteTextView) tirpr.getEditText(),R.array.ramas);
        Utils.assignOptionsAutoComplete(this,(AutoCompleteTextView) tirse.getEditText(),R.array.ramas);
        Utils.assignOptionsAutoComplete(this,(AutoCompleteTextView)tiidi.getEditText(),R.array.idiomas);
        Utils.assignOptionsAutoComplete(this,(AutoCompleteTextView)ticiu.getEditText(),R.array.ciudade);
        abogado = (Abogado)getIntent().getSerializableExtra("abogado");
    }
    private boolean validate(){
        boolean b = V.validOnlyText(tirpr,-1,-1, "La rama principal debe contener solo letras");
        b&=V.validOnlyNumber(tines,20,6,"Ingrese correctamente el número de escuela");
        b&=V.validOnlyText(ticiu,-1,-1,"Ingrese correctamente la ciudad");
        return b;
    }
    protected void nextPage(View v){
        if (validate()){
            abogado.secondSignUp(V.getText(tirpr),V.getText(tirse),V.getText(tiidi),V.getText(tines),V.getText(tides),V.getText(tidir),V.getText(ticiu),V.getText(tipag));
            Intent i = new Intent(RegistroAbogados2.this,SubirFoto.class);
            i.putExtra("abogado",abogado);
            startActivity(i);
        }
        else   Toast.makeText(this,"Complete todos los campos correctamente",Toast.LENGTH_LONG).show();
    }

}
//