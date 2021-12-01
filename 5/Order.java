package com.cafe.order;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public void add(OrderItem item) {
        if (item != null) {
            if(items.isEmpty()){
                items.add(item);
            }
            else {
                for (OrderItem o : items) {
                    if (o.beverage.equals(item)) {
                        o.addQuantity();
                        return;
                    }
                }
                items.add(item);
            }
        }
    }

    public int cost() {
        int total = 0;
        if (!items.isEmpty()) {
            for (OrderItem e : items) {
                total += (e.beverage.getCost() * e.quantity);
            }
        }
        return total;
    }

    public boolean setSize(String name, String size) {
        if (!items.isEmpty()) {
            for (OrderItem o : items) {
                if (o.beverage.equals(name)) {
                    return o.beverage.setSize(size);
                }
            }
        }
        return false;
    }

    public void print() {
        int total = 0;
        if (!this.items.isEmpty()) {
            for (OrderItem o : items) {
                System.out.println(o);
                total += (o.beverage.getCost() * o.quantity);
            }
        }
        System.out.printf("Total: %,d%n", total);
    }
}
