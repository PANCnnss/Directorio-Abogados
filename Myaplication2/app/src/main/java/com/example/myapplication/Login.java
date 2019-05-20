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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class Login extends AppCompatActivity {
    private ProgressDialog pb;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private static final String TAG="Main_act";
    Button btsignin, btsignup;
    EditText edtcorr, edtcontra;
    TextView tvestado;
    Bundle bundle;
    private String corr, contra;
    @SuppressLint("MissingPermission")
    EditText v;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btsignin = findViewById(R.id.btsignin);
        edtcontra = findViewById(R.id.etcontra);
        edtcorr = findViewById(R.id.etuser);

        mAuth = FirebaseAuth.getInstance();
        pb = new ProgressDialog(this);
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

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID,String.valueOf(v.getId())); //google analytics, 1 day delay
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT,bundle);
                signin();
            }
        });
        edtcorr.requestFocus();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //Si ha accedido actualizar la vista
    }

    private void createUser(){
        if(wrongFields()) {toastMsg("Datos Incorrectos ("+ corr + "," + contra + ")",1); return;};
        mAuth.createUserWithEmailAndPassword(corr,contra).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) toastMsg("Se creó el usuario");
                else toastMsg("No se pudo crear usuario");
            }
        });
    }
    private void signin(){

        if(wrongFields()) {return;};
        pb.setMessage("Iniciando Sesión");
        pb.show();
        Log.d(TAG,"Valores: " + corr + "," + contra);
        mAuth.signInWithEmailAndPassword(corr,contra).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    toastMsg("Inicio de sesión exitoso");

                    InicioSesion();

                }
                else toastMsg("No se pudo iniciar sesión");
                pb.dismiss();
            }
        });
    }

    private boolean wrongFields(){ //verificación de campos
        corr = edtcorr.getText().toString();
        contra = edtcontra.getText().toString();
        if(corr == null || corr.equals("") || corr.length() < 8) {
            if(corr.length()<8) toastMsg("Correo demasiado corto");
            else toastMsg("Correo Vacío"); return true;}
        if(contra == null || contra.equals("") || corr.length() < 8) {
            toastMsg("Contraseña Vacía"); return true;}
        return false;
    }

    private void toastMsg(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
    private void toastMsg(String msg, int len){
        if(len!=0 && len!=1) len=0;
        Toast.makeText(getApplicationContext(),msg,len).show();
    }

    protected  void Registrar(View a){
       Intent i = new Intent(this,RegistroPersonas.class);
       startActivity(i);
    }
    protected void InicioSesion(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void toRegPersAct(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
