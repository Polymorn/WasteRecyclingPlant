package com.plant.recycle;

import com.plant.containers.Container;
import com.plant.materials.Glass;
import com.plant.materials.Material;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;

public class Resolver {

    private Handler handler;
    private GlassHandler glassHandler;
    private PaperHandler paperHandler;
    private PlasticHandler plasticHandler;

    public Resolver(Handler handler, GlassHandler glassHandler, PaperHandler paperHandler, PlasticHandler plasticHandler) {
        this.paperHandler = paperHandler;
        this.glassHandler = glassHandler;
        this.plasticHandler = plasticHandler;
        this.handler = handler;
    }

    public <MATERIAL extends Material> void resolve(Container<MATERIAL> container) {
        System.out.println("\nResolver: Define a handler for each waste type...");
        for (MATERIAL material : container.getMaterials()) {
            if (material.getClass().equals(Glass.class)) {
                glassHandler.addToRecycle((Glass) material);
            } else if (material.getClass().equals(Paper.class)) {
                paperHandler.addToRecycle((Paper) material);
            } else if (material.getClass().equals(Plastic.class)) {
                plasticHandler.addToRecycle((Plastic) material);
            } else {
                System.out.println("Resolver: Can't define a handler for this waste type");
            }
        }
        glassHandler.recycle();
        paperHandler.recycle();
        plasticHandler.recycle();
    }
}
