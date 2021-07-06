package com.plant.recycle;

import com.plant.containers.GlassContainer;
import com.plant.containers.PaperContainer;
import com.plant.containers.PlasticContainer;
import com.plant.materials.Glass;
import com.plant.materials.Paper;
import com.plant.materials.Plastic;

import java.util.ArrayList;
import java.util.List;

public class Handler {
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

    public void recycle() {
        recycleGlass();
        recyclePaper();
        recyclePlastic();
    }

    private void recycleGlass() {
        int outWeight = 0;
        for (Glass glass : inputGlassList) {
            outWeight += glass.getWeight() / compressionGlassRatio;
            glass.setWeight(glass.getWeight()/compressionGlassRatio);
        }
        glassContainer = new GlassContainer();
        glassContainer.setMaterials(inputGlassList);
        glassContainer.setWeight(outWeight);
    }

    private void recyclePaper() {
        int outWeight = 0;
        for (Paper paper : inputPaperList) {
            outWeight += paper.getWeight() / compressionPaperRatio;
            paper.setWeight(paper.getWeight()/compressionGlassRatio);
        }
        paperContainer = new PaperContainer();
        paperContainer.setMaterials(inputPaperList);
        paperContainer.setWeight(outWeight);
    }

    private void recyclePlastic() {
        int outWeight = 0;
        for (Plastic plastic : inputPlasticList) {
            outWeight += plastic.getWeight() / compressionPlasticRatio;
            plastic.setWeight(plastic.getWeight()/compressionGlassRatio);
        }
        plasticContainer = new PlasticContainer();
        plasticContainer.setMaterials(inputPlasticList);
        plasticContainer.setWeight(outWeight);
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
