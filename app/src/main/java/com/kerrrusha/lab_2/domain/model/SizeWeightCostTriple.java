package com.kerrrusha.lab_2.domain.model;

public class SizeWeightCostTriple {

    private final int size;
    private final int weight;
    private final int cost;

    public SizeWeightCostTriple(int size, int weight, int cost) {
        this.size = size;
        this.weight = weight;
        this.cost = cost;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "SizeWeightCostTriple{" +
                "size=" + size +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
