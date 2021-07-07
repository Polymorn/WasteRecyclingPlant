package com.plant.expansion;

import com.plant.containers.Container;
import com.plant.materials.Glass;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;

import java.util.Random;

public class GarbageGenerator {

    private Container garbage;

    public GarbageGenerator(Container container) {
        this.garbage = container;
    }

    public Container generate() {
        garbage.add(new Plastic(new Random().nextInt(101)));
        garbage.add(new Paper(new Random().nextInt(101)));
        garbage.add(new Glass(new Random().nextInt(101)));
        return garbage;
    }

}
