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

public class FragmentX extends Fragment implements View.OnClickListener {

    Communicator object;
    Button matrix[][]= new Button [3][3];

    public FragmentX(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.frammento_layout,container,false);

        matrix[0][0]=v.findViewById(R.id.t00); matrix[0][0].setOnClickListener(this);
        matrix[0][1]=v.findViewById(R.id.t01); matrix[0][1].setOnClickListener(this);
        matrix[0][2]=v.findViewById(R.id.t02); matrix[0][2].setOnClickListener(this);
        matrix[1][0]=v.findViewById(R.id.t10); matrix[1][0].setOnClickListener(this);
        matrix[1][1]=v.findViewById(R.id.t11); matrix[1][1].setOnClickListener(this);
        matrix[1][2]=v.findViewById(R.id.t12); matrix[1][2].setOnClickListener(this);
        matrix[2][0]=v.findViewById(R.id.t20); matrix[2][0].setOnClickListener(this);
        matrix[2][1]=v.findViewById(R.id.t21); matrix[2][1].setOnClickListener(this);
        matrix[2][2]=v.findViewById(R.id.t22); matrix[2][2].setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        int row,column;
        String id=view.getResources().getResourceName(view.getId());
        row = Integer.parseInt(String.valueOf(id.charAt(id.length()-2)));
        column = Integer.parseInt(String.valueOf(id.charAt(id.length()-1)));

        settaCasella(row,column);
        boolean b=controllaVincita();
        if(b=true)  object.winnerIs();
        object.switchToO();
    }

    private void settaCasella(int row, int column) {
        if(matrix[row][column].getText().toString().equals("")){
            object.sendMessage(row,column,"X");
            matrix[row][column].setText("X");
        }
        else{
            Toast.makeText(getContext(),"casella occupata",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Communicator){
            object=(Communicator) context;
        }else
            throw new RuntimeException(context.toString());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        object=null;
    }


    public void setChange(int row,int column){
        matrix[row][column].setText("O");
    }


    public interface Communicator {
        void sendMessage(int row, int column, String s);
        void switchToO();
        void winnerIs();
    }

    public void reset(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                matrix[i][j].setText("");
            }
        }
    }
    public boolean controllaVincita(){
        //controllo righe
        if ( (matrix[0][0].getText().equals(matrix[0][1].getText())&&matrix[0][0].getText().equals(matrix[0][2].getText()))||
                ((matrix[1][0].getText().equals(matrix[1][1].getText())&&matrix[1][0].getText().equals(matrix[1][2].getText())))||
                ((matrix[2][0].getText().equals(matrix[2][1].getText())&&matrix[2][0].getText().equals(matrix[2][2].getText())))||
                //controllo colonne
                ((matrix[0][0].getText().equals(matrix[1][0].getText())&&matrix[0][0].getText().equals(matrix[2][0].getText())))||
                ((matrix[0][1].getText().equals(matrix[1][1].getText())&&matrix[0][1].getText().equals(matrix[2][1].getText())))||
                ((matrix[0][2].getText().equals(matrix[1][2].getText())&&matrix[0][2].getText().equals(matrix[2][2].getText())))||
                //diagonali
                ((matrix[0][0].getText().equals(matrix[1][1].getText())&&matrix[0][0].getText().equals(matrix[2][2].getText())))||
                ((matrix[0][2].getText().equals(matrix[1][1].getText())&&matrix[0][2].getText().equals(matrix[2][0].getText())))
        )


            return true;
        else
            return false;



    }

}

