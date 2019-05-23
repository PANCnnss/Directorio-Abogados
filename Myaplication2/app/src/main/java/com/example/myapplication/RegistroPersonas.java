package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Clases.Cliente;
import com.example.myapplication.Clases.FireStore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroPersonas extends AppCompatActivity {
    TextInputLayout tfnom,tfapelli,tfcorreo,tfpass,tfrepass;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    ProgressDialog pd;
    private static final String TAG="Main_act";
    Cliente cregistro;
    Bundle bundle;
    private String corr, contra;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_personas);
        tfnom = findViewById(R.id.tfnom);
        tfnom.requestFocus();
        tfapelli = ((TextInputLayout)findViewById(R.id.tfape));
        tfcorreo =((TextInputLayout) findViewById(R.id.tfcor));
        tfpass = ((TextInputLayout)findViewById(R.id.tfpas));
        tfrepass = (TextInputLayout)findViewById(R.id.tfrpa);

        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null) Log.d(TAG,"Logeado " + user.getUid());
                else Log.d(TAG,"NO logeado");
            }
        };
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        bundle = new Bundle();


    }
    private void createUser(){
        if(!validar()) {toastMsg("Datos Incorrectos ("+ corr + "," + contra + ")",1); return;};

        mAuth.createUserWithEmailAndPassword(corr,contra).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Task<Void> res= FireStore.registrar(RegistroPersonas.this, cregistro, "Clientes",corr,pd);
                    regDatosAdicio(res);
                }
                else {
                    pd.dismiss();
                    toastMsg("No se pudo crear usuario");
                }
            }
        });
    }
    private boolean validar(){
        corr = tfcorreo.getEditText().getText().toString();
        contra = tfrepass.getEditText().getText().toString();
        EditText[]ar={tfnom.getEditText(),tfapelli.getEditText(),tfcorreo.getEditText(),tfpass.getEditText(),tfrepass.getEditText()};
        for (EditText aux:ar){
            if (aux.getText().length()==0){
                Toast.makeText(this, "COMPLETE TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if(tfpass.getEditText().getText().equals(tfrepass.getEditText().getText())){
            toastMsg("Contraseñas nos coinciden");
            return false;
        }
        return true;
    }

    protected  void toRegAct(View a){
        Intent i = new Intent(this,Registrar_Abogados.class);
        startActivity(i);
    }
    protected  void tomainAct(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    protected void back(View v){
        finish();
    }

    private void toastMsg(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

    private void toastMsg(String msg, int len){
        if(len!=0 && len!=1) len=0;
        Toast.makeText(getApplicationContext(),msg,len).show();
    }

    public void registrar(View view) {
        if (!validar()) return;
        pd= new ProgressDialog(this);
        pd.setMessage("Creando Usuario");
        pd.show();
        cregistro=new Cliente(corr,corr,contra,tfnom.getEditText().getText().toString(),tfapelli.getEditText().getText().toString());
        createUser();
            }

    private void regDatosAdicio(Task<Void>res){
        res.addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    pd.dismiss();
                    toastMsg("Usuario Registrado Correctamente");
                    finish();
                    tomainAct();
                }
                else{
                    toastMsg("Ocurrió un error, intente nuevamente");
                    pd.dismiss();
                }
            }
        });
    }
}
