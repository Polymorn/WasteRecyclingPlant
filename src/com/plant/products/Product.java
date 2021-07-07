package com.plant.products;

public abstract class Product {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Product(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\tProduct{" +
                "weight=" + weight +
                '}';
    }
}
