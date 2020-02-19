package com.example.rubricamaps;

import android.graphics.drawable.Drawable;

public class Contatto {
    private  String name;
    private String address;
    private Drawable picture;

    public Contatto(String n,String a,Drawable p){
        this.address=a;
        this.name=n;
        this.picture=p;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Drawable getPicture() {
        return picture;
    }
}
