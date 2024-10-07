package com.example.myapplication.ui.clothes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClothesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClothesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is clothes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}