package com.plant.prefactory;

import com.plant.containers.Container;
import com.plant.materials.Glass;
import com.plant.materials.Material;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;

public class GarbageSorter {

    private Compressor compressor;

    public GarbageSorter(Compressor compressor) {
        this.compressor = compressor;
    }

    public <MATERIAL extends Material> void sort(Container<MATERIAL> container) {
        System.out.println("\nGarbage sorter: Sorting garbage into three different heaps...");
        for (MATERIAL material : container.getMaterials()) {
            if (material.getClass().equals(Glass.class)) {
                compressor.inputGlass((Glass) material);
            } else if (material.getClass().equals(Paper.class)) {
                compressor.inputPaper((Paper) material);
            } else if (material.getClass().equals(Plastic.class)) {
                compressor.inputPlastic((Plastic) material);
            } else {
                System.out.println("Garbage sorter: can't define a heap");
            }
        }
    }
}
