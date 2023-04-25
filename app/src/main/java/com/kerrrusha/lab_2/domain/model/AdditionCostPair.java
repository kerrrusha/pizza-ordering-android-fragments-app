package com.kerrrusha.lab_2.domain.model;

public class AdditionCostPair {

    private final String addition;
    private final int cost;

    public AdditionCostPair(String addition, int cost) {
        this.addition = addition;
        this.cost = cost;
    }

    public String getAddition() {
        return addition;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "AdditionCostPair{" +
                "addition='" + addition + '\'' +
                ", cost=" + cost +
                '}';
    }
}
