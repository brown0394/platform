package com.cafe.menu;

import java.util.Objects;

public abstract class Beverage {
    public static final int TALL = 0;
    public static final int GRANDE = 1;
    public static final int VENTI = 2;


    String name; int basePrice; int size;

    public Beverage(String n, int price, int s){
        name = n;
        basePrice = price;
        size = s;
    }

    public int getCost(){
        if(size > 0){
            return this.basePrice + (size * 500);
        }
        return this.basePrice;
    }

    public boolean setSize(int size){
        this.size = size;
        return true;
    }

    public boolean setSize(String size){
        if ("TALL".equals(size))
            return setSize(TALL);
        else if ("GRANDE".equals(size))
            return setSize(GRANDE);
        else if ("VENTI".equals(size))
            return setSize(VENTI);
        return false;
    }

    @Override
    public String toString() {
        String s = "\0";
        switch(size){
            case 0 : s = "TALL"; break;
            case 1 : s = "GRANDE"; break;
            case 2 : s = "VENTI"; break;
            default: break;
        }
        return "[ name=" + name +
                ", Price=" + getCost() +
                ", size=" + s + ", ";
    }

    public boolean equals(String name) {
        if (name == null ) return false;
        return Objects.equals(this.name, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, basePrice, size);
    }
}
