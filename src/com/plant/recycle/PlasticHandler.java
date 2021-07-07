package com.plant.recycle;

import com.plant.materials.Plastic;
import com.plant.products.PlasticProduct;
import com.plant.products.Product;

import java.util.ArrayList;
import java.util.List;

public class PlasticHandler<PLASTIC extends Plastic> extends Handler {

    private List<PLASTIC> inputPlasticList = new ArrayList<>();

    private PlasticProduct plasticProduct;

    public Product recycle() {
        if (!inputPlasticList.isEmpty()) {
            System.out.println("Plastic handler: Recycling plastic...");
            int outWeight = 0;
            for (Plastic plastic : inputPlasticList) {
                plastic.setWeight(plastic.getWeight() * 2 / 3);
                outWeight += plastic.getWeight();
            }
            plasticProduct = new PlasticProduct(outWeight);
            System.out.println("Plastic handler: Output plastic product\n" + plasticProduct);
            inputPlasticList.clear();
            return plasticProduct;
        }
        return null;
    }

    public void addToRecycle(PLASTIC plastic) {
        inputPlasticList.add(plastic);
    }
}
