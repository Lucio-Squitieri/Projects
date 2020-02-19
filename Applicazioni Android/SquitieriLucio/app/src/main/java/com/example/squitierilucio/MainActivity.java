package com.example.squitierilucio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup cesti;
    RadioButton uno,due,tre;
    TextView p1,p2,p3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cesti =findViewById(R.id.scelta);
        p1=findViewById(R.id.pallinaR);
        p2=findViewById(R.id.pallinaB);
        p3=findViewById(R.id.pallinaV);
        uno=findViewById(R.id.s1);
        due=findViewById(R.id.s2);
        tre=findViewById(R.id.s3);
    }

    public void Rossa(View v) {
        if (cesti.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(), "Seleziona un cestino", Toast.LENGTH_SHORT).show();
        }
        else
        {

            if(uno.isChecked()) {
                String r=  uno.getText().toString();

                r=r.concat("R");
                uno.setText(r);

                Animation animation = new TranslateAnimation(0, 0,0, 600);
                animation.setDuration(1000);
                p1.startAnimation(animation);

            }

            if(due.isChecked()) {
                String r=  due.getText().toString();

                r=r.concat("R");
                due.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 700);
                animation.setDuration(1000);
                p1.startAnimation(animation);
            }

            if(tre.isChecked()) {
                String r=  tre.getText().toString();

                r=r.concat("R");


                Animation animation = new TranslateAnimation(0, 0,0, 800);
                animation.setDuration(1000);
                p1.startAnimation(animation);
                tre.setText(r);
            }
        }
    }





    public void Verde(View view) {
        if (cesti.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(), "Seleziona un cestino", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(uno.isChecked()) {
                String r=  uno.getText().toString();

                r=r.concat("V");
                uno.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 600);
                animation.setDuration(1000);
                p3.startAnimation(animation);
            }

            if(due.isChecked()) {
                String r=  due.getText().toString();

                r=r.concat("V");
                due.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 700);
                animation.setDuration(1000);
                p3.startAnimation(animation);
            }

            if(tre.isChecked()) {
                String r=  tre.getText().toString();

                r=r.concat("V");
                tre.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 800);
                animation.setDuration(1000);
                p3.startAnimation(animation);
            }
        }
    }

    public void Blu(View view) {
        if (cesti.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(), "Seleziona un cestino", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(uno.isChecked()) {
                String r=  uno.getText().toString();

                r=r.concat("B");
                uno.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 600);
                animation.setDuration(1000);
                p2.startAnimation(animation);
            }

            if(due.isChecked()) {
                String r=  due.getText().toString();

                r=r.concat("B");
                due.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 700);
                animation.setDuration(1000);
                p2.startAnimation(animation);
            }

            if(tre.isChecked()) {
                String r=  tre.getText().toString();

                r=r.concat("B");
                tre.setText(r);
                Animation animation = new TranslateAnimation(0, 0,0, 800);
                animation.setDuration(1000);
                p2.startAnimation(animation);
            }
        }
    }
}
