package com.plant.containers;

import com.plant.materials.Material;

import java.util.ArrayList;
import java.util.List;

public abstract class Container<MATERIAL extends Material> {

    private Class<MATERIAL> type;
    private List<MATERIAL> materials = new ArrayList<>();

    public List<MATERIAL> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MATERIAL> materials) {
        this.materials = materials;
    }

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void add(MATERIAL material) {
        materials.add(material);
        weight += material.getWeight();
    }

    public void getContent() {
        System.out.println(this + " contains: ");
        for (MATERIAL material : materials) {
            System.out.println(material.toString());
            System.out.println(material.getClass());
        }
        System.out.println("Full weight = '" + this.weight + "'");
    }

    public Class<MATERIAL> getType() {
        return type;
    }

    @Override
    public String toString() {
        return "\tContainer {" +
                "materials=" + materials +
                "} FULL WEIGHT=" + weight;
    }
}
