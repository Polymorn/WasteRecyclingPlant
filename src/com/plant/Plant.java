package com.plant;

import com.plant.containers.Container;
import com.plant.containers.GarbageContainer;
import com.plant.materials.Glass;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;
import com.plant.recycle.Handler;
import com.plant.recycle.Resolver;

public class Plant {

    private Container garbageContainer = new GarbageContainer();
    private Handler handler = new Handler();
    private Resolver resolver = new Resolver(handler);

    public void work() {
        initialize();
        resolver.resolve(garbageContainer);
        handler.recycle();

        Container productGlass = handler.getGlassContainer();
        Container productPaper = handler.getPaperContainer();
        Container productPlastic = handler.getPlasticContainer();
        System.out.println(productGlass.toString() + "\n" + productPaper.toString() + "\n" + productPlastic.toString());
    }

    public void initialize() {
        garbageContainer.add(new Glass(30));
        garbageContainer.add(new Plastic(14));
        garbageContainer.add(new Paper(10));
        System.out.println(garbageContainer);

    }
}
