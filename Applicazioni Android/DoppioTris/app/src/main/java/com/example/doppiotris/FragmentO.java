package com.example.doppiotris;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentO extends Fragment implements View.OnClickListener {

    Communicator object;
    Button matrix[][] = new Button[3][3];

    public FragmentO() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frammento_layout, container, false);

        matrix[0][0] = v.findViewById(R.id.t00);
        matrix[0][0].setOnClickListener(this);
        matrix[0][1] = v.findViewById(R.id.t01);
        matrix[0][1].setOnClickListener(this);
        matrix[0][2] = v.findViewById(R.id.t02);
        matrix[0][2].setOnClickListener(this);
        matrix[1][0] = v.findViewById(R.id.t10);
        matrix[1][0].setOnClickListener(this);
        matrix[1][1] = v.findViewById(R.id.t11);
        matrix[1][1].setOnClickListener(this);
        matrix[1][2] = v.findViewById(R.id.t12);
        matrix[1][2].setOnClickListener(this);
        matrix[2][0] = v.findViewById(R.id.t20);
        matrix[2][0].setOnClickListener(this);
        matrix[2][1] = v.findViewById(R.id.t21);
        matrix[2][1].setOnClickListener(this);
        matrix[2][2] = v.findViewById(R.id.t22);
        matrix[2][2].setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        int row, column;
        String id = view.getResources().getResourceName(view.getId());
        row = Integer.parseInt(String.valueOf(id.charAt(id.length() - 2)));
        column = Integer.parseInt(String.valueOf(id.charAt(id.length() - 1)));

        settaCasella(row, column);
        boolean b=controllaVincita();
        if(b=true) object.winnerIsO();
        object.switchToX();

    }

    private void settaCasella(int row, int column) {
        if (matrix[row][column].getText().toString().equals("")) {
            matrix[row][column].setText("O");
            object.sendMessage1(row, column, "O");
        } else {
            Toast.makeText(getContext(), "casella occupata", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Communicator) {
            object = (Communicator) context;


        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        object = null;
    }


    public void setChange(int row, int column) {
        matrix[row][column].setText("X");
    }

    public interface Communicator {
        void sendMessage1(int row, int column, String s);
        void switchToX();
        void winnerIsO();
    }
    public void reset(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                matrix[i][j].setText("");
            }
        }
    }
    public boolean controllaVincita(){
      //
return true
        ;
    }
}







