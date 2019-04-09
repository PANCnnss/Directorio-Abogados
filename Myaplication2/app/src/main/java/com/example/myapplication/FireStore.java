package com.example.myapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class FireStore {
    static ProgressDialog pb;
    public static void registrar(final AppCompatActivity activity, Object obj, String coleccion, String id, ProgressDialog p){
        pb=p;
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection(coleccion).document(id).set(obj)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(activity,"Rgistrado Correctamente",Toast.LENGTH_LONG).show();
                        pb.dismiss();
                    } })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity,"Error, por favor intente nuevamente",Toast.LENGTH_LONG).show();
                pb.dismiss();
            }
        });



    }
}
