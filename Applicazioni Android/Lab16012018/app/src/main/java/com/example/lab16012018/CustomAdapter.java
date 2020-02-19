package com.example.lab16012018;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private int resource;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Contatto> objects) {
        super(context, resourceId,objects);
        resource= resourceId;
        inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View v, @NonNull ViewGroup parent) {
        if (v == null) {
            Log.d("DEBUG","Inflating view");
            v = inflater.inflate(R.layout.list_element, null);

        }
        Contatto c= (Contatto) getItem(position);

        Button nameButton;
        Button telButton;
        ImageButton pictureButton;
        Button surnameButton;

        nameButton=v.findViewById(R.id.nome);
        telButton =v.findViewById(R.id.telefono);
        pictureButton=v.findViewById(R.id.Ritratto);
        surnameButton=v.findViewById(R.id.cognome);

        pictureButton.setImageDrawable(c.getPicture());
        nameButton.setText(c.getName());
        telButton.setText(c.getAddress());
        surnameButton.setText(c.getSurname());

        pictureButton.setTag(position);
        telButton.setTag(position);
        nameButton.setTag(position);
        surnameButton.setTag(position);

        return v;

    }
}
