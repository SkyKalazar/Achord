package com.skykalazar.achord.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.Repositories.SongsRepository;

import java.util.ArrayList;

public class SongsViewModel extends AndroidViewModel {

    private final SongsRepository repository;

    public SongsViewModel(Application app) {
        super(app);
        repository = SongsRepository.getInstance(app);

    }

    public LiveData<ArrayList<Song>> getSongs() {
        return repository.getAllSongs();
    }

    public void addSong(Song newSong) {
       repository.insert(newSong);
    }
}