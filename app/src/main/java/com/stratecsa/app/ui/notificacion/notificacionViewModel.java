package com.stratecsa.app.ui.notificacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class notificacionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public notificacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Notificacion fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}