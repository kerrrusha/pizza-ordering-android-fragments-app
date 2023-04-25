package com.kerrrusha.lab_2;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kerrrusha.lab_2.domain.validating.PizzaOrderValidator;

import java.util.ArrayList;
import java.util.List;

public class InputFormFragment extends Fragment {

    private FormViewModel viewModel;

    EditText pizzaName;
    RadioGroup radioGroup;
    LinearLayout checkboxesLinearLayout;
    Button okButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_form, container, false);
        assert view != null;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(FormViewModel.class);

        pizzaName = view.findViewById(R.id.pizzaName);
        radioGroup = view.findViewById(R.id.radio_group);
        checkboxesLinearLayout = view.findViewById(R.id.checkbox_group);
        okButton = view.findViewById(R.id.okButton);

        okButton.setOnClickListener(v -> viewModel.setFormResult(getOrder(view)));
        viewModel.getNeedsToBeCleared().observe(getViewLifecycleOwner(), needsToBeCleared -> {
            if (!needsToBeCleared) {
                return;
            }
            viewModel.setNeedsToBeCleared(false);
            clearOrder();
        });
    }

    public void clearOrder() {
        pizzaName.setText(EMPTY);
        radioGroup.clearCheck();
        clearCheckFromCheckboxes();
    }

    private void clearCheckFromCheckboxes() {
        int childCount = checkboxesLinearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = checkboxesLinearLayout.getChildAt(i);
            if (view instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) view;
                checkBox.setChecked(false);
            }
        }
    }

    private String getOrder(@NonNull View view) {
        final String SEPARATOR = "; ";

        String pizzaNameText = pizzaName.getText().toString();
        int selectedPizzaSizeRadioButtonId = radioGroup.getCheckedRadioButtonId();
        List<CheckBox> checkedCheckBoxes = getCheckedCheckboxes();

        PizzaOrderValidator validator = new PizzaOrderValidator(pizzaNameText, selectedPizzaSizeRadioButtonId);
        if (!validator.getErrors().isEmpty()) {
            showPopupWindow(String.join(SEPARATOR, validator.getErrors()));
            return EMPTY;
        }

        StringBuilder result = new StringBuilder();

        result.append(pizzaNameText).append(SEPARATOR);
        result.append(((RadioButton) view.findViewById(selectedPizzaSizeRadioButtonId)).getText().toString()).append(SEPARATOR);
        checkedCheckBoxes.forEach(e -> result.append(e.getText().toString()).append(SEPARATOR));

        return result.toString();
    }

    private void showPopupWindow(String message) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_layout, null);

        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        popupWindow.setFocusable(true);

        TextView popupText = popupView.findViewById(R.id.popup_text);
        popupText.setText(message);

        Button closeButton = popupView.findViewById(R.id.popup_button);
        closeButton.setOnClickListener(v -> popupWindow.dismiss());

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    private List<CheckBox> getCheckedCheckboxes() {
        int childCount = checkboxesLinearLayout.getChildCount();
        List<CheckBox> checkedCheckBoxes = new ArrayList<>();

        for (int i = 0; i < childCount; i++) {
            View view = checkboxesLinearLayout.getChildAt(i);
            if (view instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) view;
                if (checkBox.isChecked()) {
                    checkedCheckBoxes.add(checkBox);
                }
            }
        }

        return checkedCheckBoxes;
    }

}
