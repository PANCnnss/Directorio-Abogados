package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Clases.Abogado;
import com.example.myapplication.Clases.Adapters.AbogadoAdapter;


import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    CardView cv;

    String[] vnoms={"Juan Barbarrossa","José Carlos","Toni Maldonado"},
            vcorrs={"juanbarba@mail.com","josecarlos@mail.com","tonym@mail.com"},
            vtels={"956485621","986532145","996584756"},
            vramas={"Civil","Laboral","Deportivo"};
    double[] vcals={1.1,3.5,5.0};
    int[] imgs = {R.drawable.ab1,R.drawable.ab2,R.drawable.ab3};
    Vector<Abogado> va;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Vect","entre pto");
        RecyclerView rv = findViewById(R.id.rvCon);

        //Data Creation
        va = new Vector<Abogado>();

        for(int i=0; i<vnoms.length;i++){
            va.add(new Abogado(""+(i+1), vnoms[i], vcorrs[i], vtels[i], vramas[i],
                    "Arequipa",vcals[i],imgs[i]));
            Log.d("Vect",va.get(i).toString());
            Toast.makeText(this,"entre",Toast.LENGTH_SHORT).show();
        }


        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setAdapter(new AbogadoAdapter(va));
        rv.setLayoutManager(llm);

    }
}
