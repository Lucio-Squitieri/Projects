package com.example.lab16012018;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class SceltaDialog extends AppCompatDialogFragment {
    private CustomAdapter c;
    private Contatto a;
    public SceltaDialog(CustomAdapter a,Contatto con){c=a;
    this.a=con;}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setTitle("Alert")
                .setMessage("Vuoi davvero cancellarlo?")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    c.remove(a);
                    }


                });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    return builder.create(); };
}
