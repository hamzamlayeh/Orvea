package com.orvea.asus.orvea.Model;

/**
 * Created by user on 02/10/2018.
 */

public class ListItem {
    private String Name;
    private String Desc;

    public ListItem(String Name, String Desc){
        this.Name=Name;
        this.Desc=Desc;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}