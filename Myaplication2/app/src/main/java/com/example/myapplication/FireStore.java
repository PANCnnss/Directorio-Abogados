package com.example.myapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class FireStore {
    static ProgressDialog pb;
    public static Task<Void> registrar(final AppCompatActivity activity, Object obj, String coleccion, String id, ProgressDialog p){
        pb=p;
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        Task<Void> set = db.collection(coleccion).document(id).set(obj);
        return set;
    }
}
