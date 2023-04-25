package com.kerrrusha.lab_2;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FormResultFragment extends Fragment {

    private FormViewModel viewModel;

    Button clearButton;
    TextView resultTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_result, container, false);
        assert view != null;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(FormViewModel.class);

        clearButton = view.findViewById(R.id.clearButton);
        resultTextView = view.findViewById(R.id.resultTextView);

        clearButton.setOnClickListener(v -> {
            clearOrder();
            viewModel.setNeedsToBeCleared(true);
        });
        viewModel.getFormResult().observe(getViewLifecycleOwner(), formResult -> {
            resultTextView.setText(formResult);
        });
    }

    public void clearOrder() {
        resultTextView.setText(EMPTY);
    }

}
