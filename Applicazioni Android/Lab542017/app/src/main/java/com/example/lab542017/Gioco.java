package com.example.lab542017;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.Random;

public class Gioco extends AppCompatActivity {

    Intent i;
    int iterazione=1;
    Button matrix[][]= new Button [3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gioco);
         i=getIntent();

        matrix[0][0] = findViewById(R.id.t00);

        matrix[0][1] =findViewById(R.id.t01);

        matrix[0][2] = findViewById(R.id.t02);

        matrix[1][0] = findViewById(R.id.t10);

        matrix[1][1] = findViewById(R.id.t11);

        matrix[1][2] = findViewById(R.id.t12);

        matrix[2][0] = findViewById(R.id.t20);

        matrix[2][1] = findViewById(R.id.t21);

        matrix[2][2] = findViewById(R.id.t22);

        creaTavola();
    }

    private void creaTavola() {
        Random random = new Random();

        int[] a = new int[11];
        a[10]=0;

        int y = 0;
        while (y!=9) {
            int x = random.nextInt(10);

            if (contiene(x,a)) {

                a[y] = x;
                y++;
            }

        }


        int m = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j].setText(String.valueOf(a[m]));
                m++;

            }

        }


    }


    private boolean contiene(int x,int[] a) {
        boolean b=true;
     for(int i=0;i<10;i++)
                if(a[i]==x) b=false;

                return b;
    }

    public void controlla(View v) {
        Button b= v.findViewById(v.getId());

        if(Integer.parseInt(b.getText().toString())==iterazione) {

            if(iterazione==2){
                String s="lo abbiamo fatto";
                i.putExtra("risultato",s);
                setResult(1,i);
                finish();
            }

            creaTavola();
            iterazione++;
        }

    }
}

