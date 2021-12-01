package com.cafe.menu;

public class Teavana extends Beverage{
    private int amount;

    public Teavana(String name){
        super(name, 4100, TALL);
    }

    @Override
    public boolean setSize(int size) {
        if(size != GRANDE){
            super.setSize(size);
            return true;
        }
        return false;
    }
}
