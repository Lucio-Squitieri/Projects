package com.example.labcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup primo,secondo,contorno,frutta;
    RadioButton uno,due,tre,quattro;
    TextView tot;
    int cp=0,cs=0,cc=0,cf=0,costo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primo =findViewById(R.id.primo);
        secondo =findViewById(R.id.secondo);
        contorno =findViewById(R.id.contorno);
        frutta =findViewById(R.id.frutta);
        tot= findViewById(R.id.totale);
    }





    public void checkMenu(View v){

        int p=primo.getCheckedRadioButtonId();
        uno=v.findViewById(p);
        if(uno != null) cp=Integer.parseInt(uno.getText().toString());


        int s=secondo.getCheckedRadioButtonId();
        due=v.findViewById(s);
        if(due != null) cs=Integer.parseInt(due.getText().toString());


        int c =contorno.getCheckedRadioButtonId();
        tre=v.findViewById(c);
        if(tre != null) cc=Integer.parseInt(tre.getText().toString());


        int f= frutta.getCheckedRadioButtonId();
        quattro=v.findViewById(f);
        if(quattro != null) cf=Integer.parseInt(quattro.getText().toString());




       costo=cp+cs+cc+cf;
        System.out.println("primo "+cp);
        System.out.println("secondo "+cs);
        System.out.println("contorno "+cc);
        System.out.println("frutta "+cf);
            String prezzo =String.valueOf(costo);

            System.out.println(prezzo);
       tot.setText(prezzo);
}

    public void cassa(View view) {
        Intent i =new Intent(this, ActivityCassa.class);
        i.putExtra("primo",cp);
        i.putExtra("secondo",cs);
        i.putExtra("contorno",cc);
        i.putExtra("frutta",cf);
        i.putExtra("totale",costo);

        startActivity(i);

    }
}
