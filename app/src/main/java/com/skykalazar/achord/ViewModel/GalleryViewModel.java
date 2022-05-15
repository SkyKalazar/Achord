package com.skykalazar.achord.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a gallery fragment for chords, memorable moments and insights");
    }

    public LiveData<String> getText() {
        return mText;
    }
}