package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroPersonas extends AppCompatActivity {
    EditText tfnom,tfapelli,tfcorreo,tfpass,tfrepass;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private static final String TAG="Main_act";
    Button btsignup;
    EditText edtcorr, edtcontra;
    TextView tvestado;
    Bundle bundle;
    private String corr, contra;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_personas);
        tfnom = findViewById(R.id.tfnom);
        tfnom.requestFocus();
        tfapelli = findViewById(R.id.tfape);
        tfcorreo = findViewById(R.id.tfcorreo);
        tfpass = findViewById(R.id.tfpass);
        tfrepass = findViewById(R.id.tfrepass);

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
                    toastMsg("Se creó el usuario");
                    tomainAct();
                }
                else toastMsg("No se pudo crear usuario");
            }
        });
    }
    private boolean validar(){
        corr = tfcorreo.getText().toString();
        contra = tfrepass.getText().toString();
        EditText[]ar={tfnom,tfapelli,tfcorreo,tfpass,tfrepass};
        for (EditText aux:ar){
            if (aux.getText().length()==0){
                Toast.makeText(this, "COMPLETE TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if(tfpass.getText().equals(tfrepass.getText())){
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
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Creando Usuario");
        pd.show();
        FireStore.registrar(this, new Cliente(corr,corr,contra,tfnom.getText().toString(),tfapelli.getText().toString()), "Clientes",corr,pd);
        createUser();
    }
}
