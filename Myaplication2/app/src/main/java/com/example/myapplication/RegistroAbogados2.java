package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegistroAbogados2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_abogados2);
    }

    protected void nextPage(View v){
        startActivity(new Intent(RegistroAbogados2.this,SubirFoto.class));
    }

}
