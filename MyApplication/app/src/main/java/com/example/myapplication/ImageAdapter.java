package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContexto;
    public ImageAdapter (Context c){
        mContexto = c;
    }
    public int getCount(){
        return mListaIds.length;
    }
    public Object getItem(int posicion){
        return null;
    }
    public long getItemId(int posicion){
        return 0;
    }
    public View getView(int posicion, View converVista, ViewGroup padre){
        ImageView imgVista = new ImageView(mContexto);
        imgVista.setImageResource(mListaIds[posicion]);
        return imgVista;
    }
    private Integer[] mListaIds ={

    };
}