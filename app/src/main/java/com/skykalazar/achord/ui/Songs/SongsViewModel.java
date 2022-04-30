package com.skykalazar.achord.ui.Songs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class SongsViewModel extends ViewModel {

    private MutableLiveData<RecyclerView> songs;

    public SongsViewModel(RecyclerView recyclerView) {
        songs = new MutableLiveData<>(recyclerView);
    }

    public LiveData<RecyclerView> getSongs() {
        return songs;
    }
}