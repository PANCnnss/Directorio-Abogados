package com.example.myapplication;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import  com.example.myapplication.Clases.Abogado;


public class showAbogado extends AppCompatActivity {
    private Abogado ab;
    private TextView txtel;
    private TextView txciud, txnom, txrama, txcor;
    private ImageView saivabg;
    RatingBar rbcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_abogado);

        Intent in = this.getIntent();
        ab = (Abogado) in.getSerializableExtra("abg");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ab.getCorreo()});
                email.putExtra(Intent.EXTRA_SUBJECT, "Layers");
                email.putExtra(Intent.EXTRA_TEXT, "Hola de parte de Layers");

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        //GetVistas

        txtel = findViewById(R.id.txtel);
        txciud = findViewById(R.id.txciud);
        txnom = findViewById(R.id.txnom);
        txrama = findViewById(R.id.txrama);
        txcor = findViewById(R.id.txcor);
        rbcal = findViewById(R.id.rbcal);
        saivabg = findViewById(R.id.saivabg);

        //Set Data in Views
        txtel.setText(ab.getTelefono());
        txciud.setText(ab.getCiudad());
        txnom.setText(ab.getNombre());
        txrama.setText(ab.getRama1());
        txcor.setText(ab.getCorreo());
        saivabg.setImageResource(ab.getImagen());
        rbcal.setRating((float) ab.getCalificacion());

        //Permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d("PLAYGROUND", "Permission is not granted, requesting");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
        } else
            Log.d("PLAYGROUND", "Permission is granted");

        //Listeners
        txtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent it = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+ab.getTelefono()));
                    it.putExtra("sms_body", "Hola de parte de Layers");
                    startActivity(it);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        txcor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ab.getCorreo()});
                email.putExtra(Intent.EXTRA_SUBJECT, "Layers");
                email.putExtra(Intent.EXTRA_TEXT, "Hola de parte de Layers");

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


    }

    public void sendMessage(View view) {

    }
}
