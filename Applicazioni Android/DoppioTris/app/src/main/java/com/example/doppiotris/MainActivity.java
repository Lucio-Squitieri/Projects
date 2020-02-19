package com.example.doppiotris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements FragmentX.Communicator, FragmentO.Communicator{
    FragmentX fm1;
    FragmentO fm2;
    FragmentManager fragmentManager;
    FragmentTransaction ft,ft1,ft2;
    Button b;
    View x,o;
    int px=0;

            int po=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String F_TAG1 ="FM1";
        String F_TAG2 ="FM2";

        fragmentManager = getSupportFragmentManager();
        ft =fragmentManager.beginTransaction();

        fm1 =new FragmentX();
        fm2 =new FragmentO();

        ft.add(R.id.frameX,fm1,"X");
        ft.add(R.id.frameO,fm2,"O");

        ft.commit();
    }

    public void switchToX(){
        x=findViewById(R.id.frameX);
        x.setVisibility(View.VISIBLE);
        o=findViewById(R.id.frameO);
        o.setVisibility(View.INVISIBLE);
    }

    @Override
    public void winnerIsO() {
        TextView t= findViewById(R.id.pto);
        po=po+1;

        t.setText(String.valueOf(po));
        reset(x);
    }

    public void switchToO(){
        x=findViewById(R.id.frameX);
        x.setVisibility(View.INVISIBLE);
        o=findViewById(R.id.frameO);
        o.setVisibility(View.VISIBLE);
        reset(o);
    }

    @Override
    public void winnerIs() {
        TextView t= findViewById(R.id.ptx);
        px=px+1;
        t.setText(String.valueOf(px));
    reset(x);
    }


    @Override
    public void sendMessage(int row, int column, String s) {


        fm2.setChange(row,column);

    }
    @Override
    public void sendMessage1(int row, int column, String s) {


        fm1.setChange(row,column);

    }


            public void reset(View view) {
                fm1.reset();
                fm2.reset();
                x=findViewById(R.id.frameX);
                x.setVisibility(View.VISIBLE);
                o=findViewById(R.id.frameO);
                o.setVisibility(View.VISIBLE);
            }



}

