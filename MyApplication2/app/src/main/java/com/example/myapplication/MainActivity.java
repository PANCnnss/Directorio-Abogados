package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //EditText text = (EditText) findViewById(R.id.editText2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*
    public void miClicManejador(View view) {
        switch (view.getId()) {
            case R.id.button:
                RadioButton dolaresButton = (RadioButton)
                        findViewById(R.id.r0);
                RadioButton solesButton = (RadioButton)
                        findViewById(R.id.r1);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Ingresa un número válido",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (dolaresButton.isChecked()) {
                    text.setText(String
                            .valueOf(convierteDolaresASoles (inputValue)));
                    dolaresButton.setChecked(false);
                    solesButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(convierteSolesADolares(inputValue)));
                    solesButton.setChecked(false);
                    dolaresButton.setChecked(true);
                }
                break;
        }
    }
    private double convierteSolesADolares(float soles) {
        return (soles/3.5);
    }
    // Convierte a soles
    private double convierteDolaresASoles(float dolares) {
        return (dolares*3.5);
    }

*/
}
