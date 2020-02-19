
package com.example.lab16012018;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;




import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.lab16012018.Contatto;
import com.example.lab16012018.CustomAdapter;
import com.example.lab16012018.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    CustomAdapter customAdapter;
    ListView list;
    EditText n,s,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        n=findViewById(R.id.name);
        s=findViewById(R.id.surname);
        t=findViewById(R.id.tel);
        String[] nomi = {"Nello", "Lucio", "Maria", "Luca", "Luigi", "Antonio"};
        String[] cognomi = {"Nello", "Lucio", "Maria", "Luca", "Luigi", "Antonio"};

        list = findViewById(R.id.Rubrica);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        list.setAdapter(customAdapter);
        for (int i = 0; i < nomi.length; i++) {
            Contatto c = new Contatto(
                    nomi[i],
                    cognomi[i],
                    "331-1210",
                    getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
        }


    }

    public void cliccato(View v) {
        Log.d("DEBUG", "Name has been clicked position=" + v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = (Contatto) customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                "Click su Nome - posizione n." + position + ": " + c.getName(), Toast.LENGTH_LONG)
                .show();
        SceltaDialog d= new SceltaDialog(customAdapter,c);
        d.show( getSupportFragmentManager(),"scelta");

}
public void inserisci(View v){


        String nome,cognome,telefono;
        nome= (String) n.getText().toString();
        cognome= (String) s.getText().toString();
        telefono= (String) t.getText().toString();
        System.out.println(nome+cognome+telefono);
            Contatto c= new Contatto(nome,cognome,telefono,getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
}

}