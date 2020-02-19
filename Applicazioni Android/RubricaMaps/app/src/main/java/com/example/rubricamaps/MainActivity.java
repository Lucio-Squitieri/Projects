package com.example.rubricamaps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1 ;
    CustomAdapter customAdapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        String[] nomi = {"Nello", "Lucio", "Maria", "Luca", "Luigi", "Antonio"};

        list = findViewById(R.id.Rubrica);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        list.setAdapter(customAdapter);
        for (int i = 0; i < nomi.length; i++) {
            Contatto c = new Contatto(
                    nomi[i],
                    "Fisciano",
                    getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
        }


    }

    public void onPictureClick(View v) {
        Log.d("DEBUG", "Picture has been clicked: position=" + v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = (Contatto) customAdapter.getItem(position);
        lanciaActivity(v);

    }

    public void onNameClick(View v) {
        Log.d("DEBUG", "Name has been clicked position=" + v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = (Contatto) customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                "Click su Nome - posizione n." + position + ": " + c.getName(), Toast.LENGTH_LONG)
                .show();
    }

    public void onAddressClick(View v) {
        Log.d("DEBUG", "Tel has been clicked position=" + v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = (Contatto) customAdapter.getItem(position);
        visualizzaMappaClicked(v, c.getAddress());


    }

    public void visualizzaMappaClicked(View v, String s) {
        String address = s;
        if (null != address) {
            address = address.replace(' ', '+');
            Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
            startActivity(geoIntent);
        }
    }

    public void lanciaActivity(View v) {
        Intent i = new Intent(getApplicationContext(), Activity1.class);
        startActivity(i);
    }




}