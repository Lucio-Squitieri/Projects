package com.example.labcheckbox;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityCassa extends AppCompatActivity {
    private Intent i;
    private TextView a, y, c, d, e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cassa_layout);

        i = getIntent();
        Bundle b = i.getExtras();
        int primo = b.getInt("primo");
        int secondo = b.getInt("secondo");
        int contorno = b.getInt("contorno");
        int frutta = b.getInt("frutta");
        int totale = b.getInt("totale");

        a=findViewById(R.id.t);
        y=findViewById(R.id.pri);
        c=findViewById(R.id.sec);
        d=findViewById(R.id.con);
        e=findViewById(R.id.fru);

        a.setText("Totale:"+totale);
        y.setText("primo:"+primo+"$");
        c.setText("secondo:"+secondo+"$");
        d.setText("contorno:"+contorno+"$");
        e.setText("Frutta:"+frutta+"$");
    }
}
