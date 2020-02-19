package com.example.lab16012018;

import android.graphics.drawable.Drawable;

public class Contatto {
    private String name;
    private String surname;
    private String address;
    private Drawable picture;

    public Contatto(String name, String surname,String address,Drawable picture) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }
}