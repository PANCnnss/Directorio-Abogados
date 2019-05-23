package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.Clases.Abogado;
import com.example.myapplication.Clases.FireStore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class SubirFoto extends AppCompatActivity {
    private int PICK_IMAGE_REQUEST = 1;
    private boolean hasPhoto;
    private Uri uri;
    ProgressDialog pd;
    private StorageReference mStorage;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private Abogado abogado;
    private ImageView imgprof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_foto);
        hasPhoto = false;
        mAuth = FirebaseAuth.getInstance();
        mStorage = FirebaseStorage.getInstance().getReference();
        imgprof = findViewById(R.id.prof_img);
        abogado = (Abogado) getIntent().getSerializableExtra("abogado");
        pd = new ProgressDialog(SubirFoto.this);

    }

    protected void selectPhoto(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri=data.getData();
        imgprof.setImageURI(uri);
        hasPhoto=true;


    }

    protected void registro(View v) {
        pd.setMessage("Creando Usuario");
        pd.show();

        mAuth.createUserWithEmailAndPassword(abogado.getCorreo(), abogado.getPassword()).addOnCompleteListener(SubirFoto.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Task<Void> res = FireStore.registrar(SubirFoto.this, abogado, "Abogados", abogado.getCorreo(), pd);
                    subirFoto(res);
                } else {
                    pd.dismiss();
                    Toast.makeText(SubirFoto.this,"Error al registro usuario, Intente nuevamente",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void subirFoto(Task res) {
        res.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    if (hasPhoto){
                      firebaseUser = mAuth.getCurrentUser();
                      StorageReference f = mStorage.child("FPerfiles").child(abogado.getCorreo());
                      f.putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                          @Override
                          public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                              if (task.isSuccessful()){
                                  Toast.makeText(SubirFoto.this,"Usuario Registrado Correctamente",Toast.LENGTH_SHORT).show();
                                  finish();
                                  Intent i = new Intent(SubirFoto.this,MainActivity.class);
                                  startActivity(i);
                              }
                              else{
                                  Toast.makeText(SubirFoto.this,"Ocurrió un error",Toast.LENGTH_SHORT).show();
                                  }
                              pd.dismiss();
                          }
                     });
                    }
                    else {
                        Toast.makeText(SubirFoto.this,"Usuario Registrado Correctamente",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
