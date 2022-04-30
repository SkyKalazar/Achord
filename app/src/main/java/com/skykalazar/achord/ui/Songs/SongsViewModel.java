package com.skykalazar.achord.ui.Songs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SongsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SongsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is musical symphony that hasn't been seen before");
    }

    public LiveData<String> getText() {
        return mText;
    }
}