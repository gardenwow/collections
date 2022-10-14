package com.exampleskypro.collections;

public class Item {
    private final int id;
    private final String name;
    private final double price;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
