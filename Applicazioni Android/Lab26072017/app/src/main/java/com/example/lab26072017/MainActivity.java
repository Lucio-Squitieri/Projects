package com.example.lab26072017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView totale;
    int tot=0,a=0,b=0,c=0,d=0,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totale= findViewById(R.id.totale);
    }

    public void aggiornaPrezzo(View view) {
        switch (view.getId()) {


            case R.id.acqua:
                if(((CheckBox) view).isChecked()){
                    tot=tot+1;
                    a=1;
                }
                else{
                    tot=tot-1;
                    a=0;
                }

                break;
            case R.id.carne:
                if(((CheckBox) view).isChecked()){
                    tot=tot+1;
                    b=1;
                }
                else {
                    tot = tot - 1;
                b=0;
                }
                break;
            case R.id.pizza:
                if(((CheckBox) view).isChecked()){
                    c=1;
                    tot=tot+1;
                }
                else {
                    c = 0;
                    tot = tot - 1;
                }
                break;
            case R.id.vino:
                if(((CheckBox) view).isChecked()){
                    tot=tot+1;
                    d=1;
                }
                else {
                    d = 0;
                    tot = tot - 1;
                }
                break;

        }
        totale.setText("Totale"+tot+"$");
        price= tot;
    }

    public void paga(View view) {
        Intent i= new Intent(this, Ordine.class);
        i.putExtra("acqua",a);
        i.putExtra("carne",b);
        i.putExtra("pizza",c);
        i.putExtra("vino",d);

        i.putExtra("totale",price);
        startActivity(i);
    }
}