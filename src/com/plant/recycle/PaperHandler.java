package com.plant.recycle;

import com.plant.materials.Paper;
import com.plant.products.PaperProduct;
import com.plant.products.Product;
import com.plant.terminal.ConsoleColors;

import java.util.ArrayList;
import java.util.List;

public class PaperHandler<PAPER extends Paper> extends Handler {

    private List<PAPER> inputPaperList = new ArrayList<>();

    private PaperProduct paperProduct;

    public Product recycle() {
        if (!inputPaperList.isEmpty()) {
            System.out.println(ConsoleColors.ANSI_CYAN + "Paper handler: " + ConsoleColors.ANSI_RESET + "Recycling paper...");
            int outWeight = 0;
            for (Paper paper : inputPaperList) {
                paper.setWeight(paper.getWeight() * 2 / 3);
                outWeight += paper.getWeight();
            }
            paperProduct = new PaperProduct(outWeight);
            System.out.println(ConsoleColors.ANSI_CYAN + "Paper handler: " + ConsoleColors.ANSI_RESET + "Output paper product\n" + paperProduct);
            inputPaperList.clear();
            return paperProduct;
        }

        return null;
    }

    public void addToRecycle(PAPER paper) {
        inputPaperList.add(paper);
    }
}
