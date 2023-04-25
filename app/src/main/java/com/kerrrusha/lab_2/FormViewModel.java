package com.kerrrusha.lab_2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FormViewModel extends ViewModel {

    private final MutableLiveData<String> formResult = new MutableLiveData<>();
    private final MutableLiveData<Boolean> needsToBeCleared = new MutableLiveData<>();

    public MutableLiveData<String> getFormResult() {
        return formResult;
    }

    public void setFormResult(String formResult) {
        this.formResult.setValue(formResult);
    }

    public MutableLiveData<Boolean> getNeedsToBeCleared() {
        return needsToBeCleared;
    }

    public void setNeedsToBeCleared(boolean needsToBeCleared) {
        this.needsToBeCleared.setValue(needsToBeCleared);
    }

}
