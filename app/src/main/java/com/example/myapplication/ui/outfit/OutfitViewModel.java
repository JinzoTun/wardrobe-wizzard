package com.example.myapplication.ui.outfit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OutfitViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public OutfitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is outfit fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}