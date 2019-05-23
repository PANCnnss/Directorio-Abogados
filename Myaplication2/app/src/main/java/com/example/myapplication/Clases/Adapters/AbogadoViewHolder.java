package com.example.myapplication.Clases.Adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class AbogadoViewHolder extends ViewHolder implements View.OnClickListener {
    protected ImageView imagen;
    protected  View v2;
    protected TextView vNom, vRam, vCiud;
    protected RatingBar vCalif;
    protected CardView cv;

    public AbogadoViewHolder(@NonNull View v) {
        super(v);

        imagen = v.findViewById(R.id.dimg);
        vNom = v.findViewById(R.id.dnom);
        vRam = v.findViewById(R.id.dram);
        vCiud = v.findViewById(R.id.dciud);
        vCalif = v.findViewById(R.id.dcal);

    }

    @Override
    public void onClick(View v) {
        Log.d("Deb", "Here, after a click Extra");
    }
}