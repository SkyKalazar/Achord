package com.skykalazar.achord.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VideosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VideosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a fragment for instructional videos and licks");
    }

    public LiveData<String> getText() {
        return mText;
    }
}