package com.example.buoi5;

import android.media.Image;

import java.io.Serializable;

public class Student implements Serializable{
    protected String name;
    protected String dob;
    protected String id;
    protected int image;
    public Student(String ten, String date, String id, int image)
    {
        this.name = ten;
        this.dob = date;
        this.id = id;
        this.image = image;
    }

    public Student() {}

    public String getDob() {
        return dob;
    }

    public int getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
