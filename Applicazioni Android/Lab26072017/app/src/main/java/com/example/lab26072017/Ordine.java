package com.example.lab26072017;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Ordine extends AppCompatActivity {
    private Intent i;
TextView totale,ordine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordine_layout);
        i=getIntent();
        Bundle extra=i.getExtras();
        int a= extra.getInt("acqua");
        int b= extra.getInt("carne");
        int c=extra.getInt("pizza");
        int d=extra.getInt("vino");

        TextView totale=findViewById(R.id.tot) ;
        TextView ordine= findViewById(R.id.riepilogo);

        String recap=" ";
        if(a==1)recap=recap.concat("\n acqua 1$ ");
        if(b==1)recap=recap.concat("\n carne 1$");
        if(c==1)recap=recap.concat("\n pizza 1$");
        if(d==1)recap=recap.concat("\n vino 1$");

        ordine.setText("Hai ordinato "+recap);
        int tot=extra.getInt("totale");

        totale.setText("Totale "+tot);


    }
}
