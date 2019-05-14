package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class Registrar_Abogados extends AppCompatActivity {

    TextInputLayout tinom,tiape,tifna,ticel,titel,ticor,ticon,tirco;


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
    }
    private boolean validar(){
        boolean b=true;
        b&=V.validOnlyText(tinom,-1,-1,"El nombre debe contener solo letras");
        b&=V.validOnlyText(tiape,-1,-1,"Los apellidos deben contener solo letras");
        b&=V.validateDate(tifna,"La fecha de nacimiento deberá estar en el formato dd/mm/aaaa");
        b&=V.validOnlyNumber(ticel,9,9,"El número de celular debe ser de 9 dígitos") ;
        b&=V.validEmail(ticor,"Ingrese correctamente el correo electrónico");
        b&=V.areEqual(ticon,tirco,"No coinciden las contraseñas");
        return b;
    }
    protected  void nextPage(View v){
        if (validar()){
            Abogado abo = new Abogado();
            Intent i = new Intent(this,RegistroAbogados2.class);
            startActivity(i);

        }


    }

}