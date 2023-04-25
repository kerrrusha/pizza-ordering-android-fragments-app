package com.kerrrusha.lab_2.domain.factory;

import static java.util.Arrays.asList;

import com.kerrrusha.lab_2.domain.model.AdditionCostPair;

import java.util.List;

public class AdditionCostPairFactory {

    public static List<AdditionCostPair> createStandart() {
        return asList(
                new AdditionCostPair("Chicken", 2500),
                new AdditionCostPair("Cheese", 2500),
                new AdditionCostPair("Pickles", 2000)
        );
    }

}
