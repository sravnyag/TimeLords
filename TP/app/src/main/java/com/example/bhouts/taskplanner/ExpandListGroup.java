package com.example.bhouts.taskplanner;

/**
 * Created by bhouts on 7/13/2016.
 */

import java.util.ArrayList;

public class ExpandListGroup {
    private String Name;
    private ArrayList<ExpandListChild> Items;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public ArrayList<ExpandListChild> getItems() {
        return Items;
    }
    public void setItems(ArrayList<ExpandListChild> Items) {
        this.Items = Items;
    }
}

