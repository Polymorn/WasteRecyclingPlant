package com.plant.materials;

public abstract class Material {

    private int weight;

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Material(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Material{" +
                "weight=" + weight +
                '}';
    }

}
