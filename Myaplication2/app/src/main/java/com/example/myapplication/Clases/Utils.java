package com.example.myapplication.Clases;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;

import java.util.Calendar;

public class Utils {
    public static EditText auxEt;
    public static int getSize(TextInputLayout ti){
        return  ti.getEditText().getText().toString().length();
    }
    public static void DatePickerDialog (EditText et, final AppCompatActivity activity){
        auxEt =et;
        auxEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    helperDatePickerDialog(activity);
                }
            }
        });
        auxEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helperDatePickerDialog(activity);
            }
        });


    }
    private static void helperDatePickerDialog (AppCompatActivity activity){
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR),m = c.get(Calendar.MONTH),d=c.get(Calendar.MONTH);
        DatePickerDialog dp = new DatePickerDialog(activity, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                auxEt.setText(getTwoDigits(dayOfMonth)+"/"+getTwoDigits(month+1)+"/"+year);
            }
        },y,m,d
        );

        dp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dp.show();
    }
    public static String getTwoDigits(int x){
        String s=String.valueOf(x);
        return (x<10)? "0"+s:s;
    }

    public static void assignOptionsAutoComplete(AppCompatActivity dis,AutoCompleteTextView autoCompleteTextView,int array){
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(dis, android.R.layout.simple_dropdown_item_1line, dis.getResources().getStringArray(array)));
        autoCompleteTextView.setThreshold(2);
        if (autoCompleteTextView instanceof MultiAutoCompleteTextView) ((MultiAutoCompleteTextView) autoCompleteTextView).setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

}
