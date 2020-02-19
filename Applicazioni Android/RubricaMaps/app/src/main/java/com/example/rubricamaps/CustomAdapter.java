package com.example.rubricamaps;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        Button addressButton;
        ImageButton pictureButton;

        nameButton=v.findViewById(R.id.nome);
        addressButton=v.findViewById(R.id.indirizzo);
        pictureButton=v.findViewById(R.id.Ritratto);

        pictureButton.setImageDrawable(c.getPicture());
        nameButton.setText(c.getName());
        addressButton.setText(c.getAddress());

        pictureButton.setTag(position);
        nameButton.setTag(position);
        addressButton.setTag(position);

        return v;

    }
}
