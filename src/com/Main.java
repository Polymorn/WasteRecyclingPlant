package com;

import com.plant.Plant;
import com.plant.containers.Container;
import com.plant.containers.GarbageContainer;
import com.plant.expansion.GarbageGenerator;
import com.plant.prefactory.Compressor;
import com.plant.prefactory.GarbageSorter;
import com.plant.recycle.*;

public class Main {

    public static void main(String[] args) {

        // Initialize
        Container garbageContainer = new GarbageContainer();
        Compressor compressor = new Compressor();
        GarbageSorter garbageSorter = new GarbageSorter(compressor);
        Handler handler = new Handler();
        GlassHandler glassHandler = new GlassHandler();
        PaperHandler paperHandler = new PaperHandler();
        PlasticHandler plasticHandler = new PlasticHandler();
        Resolver resolver = new Resolver(handler, glassHandler, paperHandler, plasticHandler);
        GarbageGenerator garbageGenerator = new GarbageGenerator(garbageContainer);
        Plant plant = new Plant(garbageContainer, compressor, garbageSorter, resolver, handler);

        // Entry point
        plant.recycle(garbageGenerator.generate());

    }

}
