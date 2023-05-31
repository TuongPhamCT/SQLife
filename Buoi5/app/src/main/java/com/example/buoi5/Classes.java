package com.example.buoi5;

import java.io.Serializable;

public class Classes implements Serializable {
    protected String idclass;
    protected String nameclass;
    protected int stuclass;
    public Classes(String id, String name, int stu)
    {
        this.idclass = id;
        this.nameclass = name;
        this.stuclass = stu;
    }
    public Classes(String id, String name)
    {
        this.idclass = id;
        this.nameclass = name;
        this.stuclass = 3;
    }

    public Classes() {}
    public String getIdclass(){return idclass;}
    public String getNameclass() {return nameclass;}

    public int getStuclass() {
        return stuclass;
    }

    public void setIdclass(String idclass) {
        this.idclass = idclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public void setStuclass(int stuclass) {
        this.stuclass = stuclass;
    }
}
