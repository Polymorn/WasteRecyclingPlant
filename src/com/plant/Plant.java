package com.plant;

import com.plant.containers.Container;
import com.plant.containers.GarbageContainer;
import com.plant.materials.Glass;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;
import com.plant.recycle.Handler;
import com.plant.recycle.Resolver;

public class Plant {

    private Container garbageContainer;
    private Handler handler;
    private Resolver resolver;

    public void work() {
        initialize();
        resolver.resolve(garbageContainer);
        handler.recycle();
    }

    public void initialize() {
        garbageContainer = new GarbageContainer();
        handler = new Handler();
        resolver = new Resolver(handler);
        garbageContainer.add(new Glass(30));
        garbageContainer.add(new Plastic(14));
        garbageContainer.add(new Paper(10));
        System.out.println("Plant: Incoming new garbage container: \n" + garbageContainer);

    }
}
