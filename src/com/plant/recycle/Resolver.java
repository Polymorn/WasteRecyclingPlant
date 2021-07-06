package com.plant.recycle;

import com.plant.containers.Container;
import com.plant.materials.Glass;
import com.plant.materials.Material;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;

public class Resolver {

    private Handler handler;

    public Resolver(Handler handler) {
        this.handler = handler;
    }

    public <MATERIAL extends Material> void resolve(Container<MATERIAL> container) {
        System.out.println("Resolver: Define a handler for each waste type...");
        for (MATERIAL material : container.getMaterials()) {
            if (material.getClass().equals(Glass.class)) {
                handler.inputGlass((Glass) material);
            } else if (material.getClass().equals(Paper.class)) {
                handler.inputPaper((Paper) material);
            } else if (material.getClass().equals(Plastic.class)) {
                handler.inputPlastic((Plastic) material);
            } else {
                System.out.println("Resolver: Can't define a handler");
            }
        }
    }
}
