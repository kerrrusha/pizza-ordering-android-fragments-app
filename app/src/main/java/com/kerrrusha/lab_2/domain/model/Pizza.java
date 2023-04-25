package com.kerrrusha.lab_2.domain.model;

import java.util.List;

public class Pizza {

    private final String name;
    private final List<SizeWeightCostTriple> sizeWeightCostOptions;
    private final List<AdditionCostPair> additionCostOptions;

    public Pizza(String name, List<SizeWeightCostTriple> sizeWeightCostOptions, List<AdditionCostPair> additionCostOptions) {
        this.name = name;
        this.sizeWeightCostOptions = sizeWeightCostOptions;
        this.additionCostOptions = additionCostOptions;
    }

    public String getName() {
        return name;
    }

    public List<AdditionCostPair> getAdditionCostOptions() {
        return additionCostOptions;
    }

    public List<SizeWeightCostTriple> getSizeWeightCostOptions() {
        return sizeWeightCostOptions;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", sizeWeightCostOptions=" + sizeWeightCostOptions +
                ", additionCostOptions=" + additionCostOptions +
                '}';
    }
}
