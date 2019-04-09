package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroPersonas extends AppCompatActivity {
    EditText tfnom,tfapelli,tfcorreo,tfpass,tfrepass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_personas);
        tfnom = (EditText)findViewById(R.id.tfnom);
        tfnom.requestFocus();
        tfapelli= (EditText)findViewById(R.id.tfape);
        tfcorreo= (EditText)findViewById(R.id.tfcorreo);
        tfpass= (EditText)findViewById(R.id.tfpass);
        tfrepass= (EditText)findViewById(R.id.tfrepass);
    }
    protected void back(View v){
        finish();
    }
    protected  void registrar(View v){
        if (validar()){
            Toast.makeText(this, "DATOS INGRESADOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();
        }

    }
    private boolean validar(){
        EditText[]ar={tfnom,tfapelli,tfcorreo,tfpass,tfrepass};
        for (EditText aux:ar){
            if (aux.getText().length()==0){
                Toast.makeText(this, "COMPLETE TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();
                return false;
            }

        }
        return true;
    }
    protected void regAbogados(View v){
        startActivity(new Intent(this,Registrar_Abogados.class));
    }
}
