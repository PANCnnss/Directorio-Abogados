package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Clases.Abogado;
import com.example.myapplication.Clases.Utils;
import com.example.myapplication.Clases.V;

public class Registrar_Abogados extends AppCompatActivity {

    TextInputLayout tinom,tiape,tifna,ticel,titel,ticor,ticon,tirco;
    DatePickerDialog dpdial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__abogados);
        tinom = findViewById(R.id.tfnom);
        tiape= findViewById(R.id.tfape);
        tifna= findViewById(R.id.tffen);
        ticel=findViewById(R.id.tfcel);
        ticor= findViewById(R.id.tfcor);
        ticon=findViewById(R.id.tfpas);
        tirco= findViewById(R.id.tfrpa);
        Utils.DatePickerDialog(tifna.getEditText(),this);


    }

    private boolean validar() {
        boolean b = true;
        b &= V.validOnlyText(tinom, -1, -1, "El nombre debe contener solo letras");
        b &=V.validateDate(tifna,"Ingrese fecha de nacimiento");
        b&=V.validOnlyText(tiape,-1,-1,"Los apellidos deben contener solo letras");
        b&=V.validOnlyNumber(ticel,9,9,"El número de celular debe ser de 9 dígitos") ;
        b&=V.validEmail(ticor,"Ingrese correctamente el correo electrónico");
        b&=V.areEqual(ticon,tirco,"No coinciden las contraseñas");
        return b;
    }
    protected  void nextPage(View v){
        if (validar()){
            Abogado abogado = new Abogado();
            abogado.firstSignUp(V.getText(tinom),V.getText(tiape),V.getText(tifna),V.getText(ticel),V.getText(ticor),V.getText(ticon));
            Intent i = new Intent(this,RegistroAbogados2.class);
            i.putExtra("abogado",abogado);
            startActivity(i);
        }
        else Toast.makeText(this,"Complete todos los campos correctamente",Toast.LENGTH_LONG).show();

    }


}