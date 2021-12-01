package com.cafe.menu;

public class Blended extends Beverage{
    private int baseAmount;

    public Blended(String name){
        super(name, 6300, GRANDE);
    }

    @Override
    public boolean setSize(int size) {
        if(size == GRANDE){
            super.setSize(size);
            return true;
        }
        return false;
    }
}
