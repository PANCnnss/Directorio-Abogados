package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        v=(EditText)findViewById(R.id.user);
        v.requestFocus();
    }

    protected  void Registrar(View a){
       Intent i = new Intent(this,RegistroPersonas.class);
       startActivity(i);
    }
}
