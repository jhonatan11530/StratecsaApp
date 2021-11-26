package com.stratecsa.app.ui.zona;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ZonaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ZonaViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
}