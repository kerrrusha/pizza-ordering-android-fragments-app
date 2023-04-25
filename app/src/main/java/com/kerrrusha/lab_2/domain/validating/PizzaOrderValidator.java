package com.kerrrusha.lab_2.domain.validating;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrderValidator {

    private static final String BLANK_PIZZA_NAME_ERROR = "Pizza name is blank";
    private static final String NOT_SELECTED_PIZZA_SIZE_ERROR = "Pizza size was not selected";

    private static final int NOT_SELECTED_RADIO_ID_VALUE = -1;

    private final String pizzaName;
    private final int selectedPizzaSizeRadioButtonId;

    private final List<String> errors;

    public PizzaOrderValidator(String pizzaName, int selectedPizzaSizeRadioButtonId) {
        this.pizzaName = pizzaName;
        this.selectedPizzaSizeRadioButtonId = selectedPizzaSizeRadioButtonId;
        this.errors = new ArrayList<>();

        validate();
    }

    private void validate() {
        if (isBlank(pizzaName)) {
            errors.add(BLANK_PIZZA_NAME_ERROR);
        }
        if (selectedPizzaSizeRadioButtonId == NOT_SELECTED_RADIO_ID_VALUE) {
            errors.add(NOT_SELECTED_PIZZA_SIZE_ERROR);
        }
    }

    public List<String> getErrors() {
        return errors;
    }

}
