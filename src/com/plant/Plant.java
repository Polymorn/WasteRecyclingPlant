package com.plant;

import com.plant.containers.Container;
import com.plant.prefactory.Compressor;
import com.plant.prefactory.GarbageSorter;
import com.plant.recycle.Handler;
import com.plant.recycle.Resolver;

public class Plant {

    private Container garbageContainer;
    private Compressor compressor;
    private GarbageSorter garbageSorter;
    private Resolver resolver;
    private Handler handler;

    public Plant(Container container, Compressor compressor, GarbageSorter garbageSorter, Resolver resolver, Handler handler) {
        this.garbageContainer = container;
        this.compressor = compressor;
        this.garbageSorter = garbageSorter;
        this.resolver = resolver;
        this.handler = handler;
    }

    public void recycle(Container container) {
        System.out.println("Plant: Incoming new garbage container: \n" + garbageContainer);

        garbageSorter.sort(garbageContainer);
        compressor.compress();

        resolver.resolve(compressor.getGlassContainer());
        resolver.resolve(compressor.getPaperContainer());
        resolver.resolve(compressor.getPlasticContainer());
    }
}
