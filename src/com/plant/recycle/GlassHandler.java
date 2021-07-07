package com.plant.recycle;

import com.plant.materials.Glass;
import com.plant.products.GlassProduct;
import com.plant.products.Product;

import java.util.ArrayList;
import java.util.List;

public class GlassHandler<GLASS extends Glass> extends Handler {

    private List<GLASS> inputGlassList = new ArrayList<>();
    private GlassProduct glassProduct;

    public Product recycle() {
        if (!inputGlassList.isEmpty()) {
            System.out.println("Glass handler: Recycling glass...");
            int outWeight = 0;
            for (Glass glass : inputGlassList) {
                glass.setWeight(glass.getWeight() * 2 / 3);
                outWeight += glass.getWeight();
            }
            glassProduct = new GlassProduct(outWeight);
            System.out.println("Glass handler: Output glass product\n" + glassProduct);
            inputGlassList.clear();
            return glassProduct;
        }

        return null;
    }

    public void addToRecycle(GLASS glass) {
        inputGlassList.add(glass);
    }
}
