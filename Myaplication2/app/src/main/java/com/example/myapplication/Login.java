package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    EditText v;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        v=(EditText)findViewById(R.id.user);
        v.requestFocus();
    }
    protected  void login(View v){
        Toast.makeText(this,"ABRIÓ",Toast.LENGTH_LONG).show();
        Cliente cliente= new Cliente("1","jeanp@gmail.com","123456","Jean","Tello");
        db.collection("Cliente").document("jeanpi").set(cliente)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this,"Rgistrado Correctamente",Toast.LENGTH_LONG).show();
                }
                });
        Toast.makeText(this,"Cosas",Toast.LENGTH_LONG).show();
    }
    protected  void Registrar(View a){
       Intent i = new Intent(this,RegistroPersonas.class);
       startActivity(i);
    }
}
