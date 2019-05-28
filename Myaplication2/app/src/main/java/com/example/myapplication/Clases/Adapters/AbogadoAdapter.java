package com.example.myapplication.Clases.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.Clases.Abogado;
import com.example.myapplication.R;
import com.example.myapplication.showAbogado;

import java.util.Vector;

public class AbogadoAdapter extends RecyclerView.Adapter<AbogadoViewHolder> {
    private Vector<Abogado> abogs;
    private Vector<View> itviews;
    public AbogadoAdapter(Vector<Abogado> abogs) {
        this.abogs = abogs;
        itviews = new Vector<View>();

    }

    @NonNull
    @Override
    public AbogadoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_item, viewGroup,false);
        itviews.add(itemView);
        Log.d("Deb", "Creando el Holder");
        return new AbogadoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AbogadoViewHolder abogadoViewHolder, int i) {
        Log.d("Deb","EN BIND");
        final Abogado ab = abogs.get(i);
        try{
            abogadoViewHolder.vNom.setText(ab.getNombre());
            abogadoViewHolder.vCiud.setText(ab.getCiudad());
            abogadoViewHolder.vCalif.setRating((float) ab.getCalificacion());
            abogadoViewHolder.vRam.setText(ab.getRama1());
            abogadoViewHolder.imagen.setImageResource(ab.getImagen());

            Log.d("Deb","EN ONCREATE");
            final View itemView = itviews.get(i);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(itemView.getContext(), showAbogado.class);
                    in.putExtra("abg", ab);
                    //Log.d("Deb", "ABOGADO SEL: " + ab.toString());
                    itemView.getContext().startActivity(in);
                }
            });
        }catch (Exception e){
            Log.e("Deb","Error at: " + ab.toString());
        }

    }

    @Override
    public int getItemCount() {
        return abogs.size();
    }

}