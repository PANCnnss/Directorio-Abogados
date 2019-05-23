package com.example.myapplication.Clases;

import android.support.design.widget.TextInputLayout;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.example.myapplication.Clases.Utils;
public class V {
    final static String DATE_FORMAT = "dd/MM/yyyy";
    public static String getText(TextInputLayout ti){
        return  ti.getEditText().getText().toString();
    }
    public static boolean validUserName (TextInputLayout ti,String  err){
        boolean b=validUserName(getText(ti));
        Log.e("errors",String.valueOf(b));
        if(b)err=null;
        ti.setError(err);
        return b;
    }
    public static boolean validOnlyText (TextInputLayout ti,int max,int min,String err){
        boolean b= validOnlyText(getText(ti), min,max);
        if (b)err=null;
        ti.setError(err);
        return b;
    }
    public static boolean validOnlyNumber(TextInputLayout ti,int max,int min,String err){
        boolean b=validNumber(getText(ti),min,max);
        if (b) err=null;
        ti.setError(err);
        return  b;
    }
    public static boolean isEmpty(TextInputLayout ti,String err){
        if (getText(ti).length()==0) ti.setError(err);
        else {
            ti.setError(null);
            return false;
        }
        return true;
    }
    public static boolean validOnlyTextComma(TextInputLayout ti,String err,int min, int max){
        boolean b=validOnlyText(getText(ti).replace(",",""),min,max);
        if (b) err=null;
        ti.setError(err);
        return  b;
    }

    public static boolean validEmail(TextInputLayout ti,String err){
        boolean b=validEmail(getText(ti));
        if (b)err=null;
        ti.setError(err);
        return  b;
    }
    public static boolean validUserName(String s) {
        return (s.matches("[a-z0-9_-]{6,16}"));
    }
    public static boolean validOnlyText(String s,int min,int max) {
        if (s.length()==0) return false;
        String regex="[A-Za-zÑñáéíóúÁÉÍÓÚ ]*";
        if (min!=-1) regex+="{"+min+","+max+"}";
        return (s.matches(regex));
    }
    public static boolean validNumber(String s,int min,int max) {
        String regex= "[0-9]";
        if (min!=-1) regex+="{"+min+","+max+"}";
        return (s.matches(regex));
    }
    public static boolean validEmail(String x){
        return (x.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$"));
    }

    public static boolean validateDate(TextInputLayout ti,String err){
        boolean b=validateDate(getText(ti));
        if (b) err=null;
        ti.setError(err);
        return b;
    }
    public static boolean validateDate(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
           df.parse(date);
            return true;
        } catch (Exception es) {
            return false;
        }
    }
    public static boolean areEqual(TextInputLayout ti,TextInputLayout ti2, String err){
        boolean b= ti.getEditText().getText().toString().equals(ti2.getEditText().getText().toString());
        boolean aux =Utils.getSize(ti)==0 && Utils.getSize(ti2)==0;
        if (aux) err="Complete los campos";
        if (b && !aux) {
            err=null;
        }
        ti.setError(err);
        ti2.setError(err);
        return  b;
    }
}
