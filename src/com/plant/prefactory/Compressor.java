package com.plant.prefactory;

import com.plant.containers.GlassContainer;
import com.plant.containers.PaperContainer;
import com.plant.containers.PlasticContainer;
import com.plant.materials.Glass;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;

import java.util.ArrayList;
import java.util.List;

public class Compressor {
    private List<Glass> inputGlassList = new ArrayList<>();
    private List<Paper> inputPaperList = new ArrayList<>();
    private List<Plastic> inputPlasticList = new ArrayList<>();

    private GlassContainer glassContainer;

    public GlassContainer getGlassContainer() {
        return glassContainer;
    }

    private PaperContainer paperContainer;

    public PaperContainer getPaperContainer() {
        return paperContainer;
    }

    private PlasticContainer plasticContainer;

    public PlasticContainer getPlasticContainer() {
        return plasticContainer;
    }

    private final int compressionGlassRatio = 2;
    private final int compressionPaperRatio = 4;
    private final int compressionPlasticRatio = 3;

    public void compress() {
        System.out.println("\nCompressor: Initialize");
        recycleGlass();
        recyclePaper();
        recyclePlastic();
    }

    private void recycleGlass() {
        System.out.println("Compressor: Compressing glass...");
        int outWeight = 0;
        for (Glass glass : inputGlassList) {
            glass.setWeight(glass.getWeight() / compressionGlassRatio);
            outWeight += glass.getWeight();
        }
        glassContainer = new GlassContainer();
        glassContainer.setMaterials(inputGlassList);
        glassContainer.setWeight(outWeight);
        System.out.println("Compressor: Output glass container\n" + glassContainer);
    }

    private void recyclePaper() {
        System.out.println("Compressor: Compressing paper...");
        int outWeight = 0;
        for (Paper paper : inputPaperList) {
            paper.setWeight(paper.getWeight() / compressionPaperRatio);
            outWeight += paper.getWeight();
        }
        paperContainer = new PaperContainer();
        paperContainer.setMaterials(inputPaperList);
        paperContainer.setWeight(outWeight);
        System.out.println("Compressor: Output paper container\n" + paperContainer);
    }

    private void recyclePlastic() {
        System.out.println("Compressor: Compressing plastic...");
        int outWeight = 0;
        for (Plastic plastic : inputPlasticList) {
            plastic.setWeight(plastic.getWeight() / compressionPlasticRatio);
            outWeight += plastic.getWeight();
        }
        plasticContainer = new PlasticContainer();
        plasticContainer.setMaterials(inputPlasticList);
        plasticContainer.setWeight(outWeight);
        System.out.println("Compressor: Output plastic container \n" + plasticContainer);
    }

    public void inputGlass(Glass glass) {
        inputGlassList.add(glass);
    }

    public void inputPaper(Paper paper) {
        inputPaperList.add(paper);
    }

    public void inputPlastic(Plastic plastic) {
        inputPlasticList.add(plastic);
    }
}